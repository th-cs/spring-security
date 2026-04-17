package com.dev.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

    private final String SECRET_KEY = "LinuxDebianUbuntuMintArchKaliPopLinuxDebianUbuntu";

    public String generateToken(String email) {
        return Jwts
            .builder()
            .setSubject(email)
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
    }
}
