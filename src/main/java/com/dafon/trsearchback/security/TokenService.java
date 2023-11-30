package com.dafon.trsearchback.security;

import com.dafon.trsearchback.exception.Custom401Exception;
import com.dafon.trsearchback.model.*;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenService {

    @Autowired
    private Dotenv dotenv;

    public String generateTokenRegular(RegularUser regularUser) {
        try {
            var algorithm = Algorithm.HMAC256(dotenv.get("API_SECRET"));
            return JWT.create()
                    .withIssuer("API Tr Search")
                    .withClaim("Name: ", regularUser.getName())
                    .withSubject(regularUser.getEmail())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);
        } catch (
                JWTCreationException exception){
            throw new RuntimeException("Error when trying to generate token", exception);
        }
    }

    public String generateTokenCorporate(CorporateUser corporateUser) {
        try {
            var algorithm = Algorithm.HMAC256(dotenv.get("API_SECRET"));
            return JWT.create()
                    .withIssuer("API Tr Search")
                    .withClaim("Name: ", corporateUser.getName())
                    .withSubject(corporateUser.getEmail())
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

    public String getSubject(String tokenJwt) {
        try {
            var algorithm = Algorithm.HMAC256(dotenv.get("API_SECRET"));
            return JWT.require(algorithm)
                    .withIssuer("API Tr Search")
                    .build()
                    .verify(tokenJwt)
                    .getSubject()
                    ;

        } catch (JWTVerificationException exception) {
            throw new Custom401Exception("Token was no valid or expired!");
        }
    }

}
