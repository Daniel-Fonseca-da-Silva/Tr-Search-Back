package com.dafon.trsearchback.security;

import com.dafon.trsearchback.repository.CorporateUserRepository;
import com.dafon.trsearchback.repository.RegularUserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final RegularUserRepository regularUserRepository;
    private final CorporateUserRepository corporateUserRepository;

    @Autowired
    public SecurityFilter(TokenService tokenService, RegularUserRepository regularUserRepository, CorporateUserRepository corporateUserRepository) {
        this.tokenService = tokenService;
        this.regularUserRepository = regularUserRepository;
        this.corporateUserRepository = corporateUserRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        var tokenJwt = recoveryToken(request);

        if (tokenJwt != null) {
            var subject = tokenService.getSubject(tokenJwt);
            var corporateUser = corporateUserRepository.findByEmail(subject);

            if (corporateUser != null) {
                var authentication = new UsernamePasswordAuthenticationToken(corporateUser, null, corporateUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                var regulaUser = regularUserRepository.findByEmail(subject);
                var authentication = new UsernamePasswordAuthenticationToken(regulaUser, null, regulaUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null)
            return authorizationHeader.replace("Bearer ", "");

        return null;

    }
}
