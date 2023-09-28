package com.dafon.trsearchback.security;

import com.dafon.trsearchback.repository.CorporateRepository;
import com.dafon.trsearchback.repository.RegularUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RegularUserRepository regularUserRepository;

    @Autowired
    private CorporateRepository corporateRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        var tokenJwt = recoveryToken(request);

        if (tokenJwt != null) {
            var subject = tokenService.getSubject(tokenJwt);
            var corporateUser = corporateRepository.findByEmail(subject);

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
