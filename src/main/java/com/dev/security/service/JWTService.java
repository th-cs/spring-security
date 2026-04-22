package com.dev.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

    @Value("${api.security.token.secret_key}")
    private String secret_key;

    public String generateToken(String email) {
        return Jwts
            .builder()
            .setSubject(email)
            .signWith(SignatureAlgorithm.HS256, secret_key)
            .compact();
    }

    public String validateToken(String token) {
        return Jwts.parser()
            .setSigningKey(secret_key)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

}
