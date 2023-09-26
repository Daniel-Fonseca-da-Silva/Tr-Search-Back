package com.dafon.trsearchback.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.dafon.trsearchback.model.RegularUser;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenService {

    public String generateToken(RegularUser regularUser) {
        try {
            var algorithm = Algorithm.HMAC256("123321");
            return JWT.create()
                    .withIssuer("API Tr Search")
                    .withClaim("Name: ", regularUser.getUsername())
                    .withSubject(regularUser.getEmail())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);
        } catch (
                JWTCreationException exception){
            throw new RuntimeException("Error when trying to generate token", exception);
        }
    }

    private Instant dateExpiration() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }

}
