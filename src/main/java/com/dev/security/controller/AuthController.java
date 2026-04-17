package com.dev.security.controller;

import com.dev.security.dto.request.UserLoginDTO;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.dev.security.service.JWTService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
public class AuthController {

    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JWTService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO userLoginDTO) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                userLoginDTO.email(),
                userLoginDTO.password()
            )
        );
        return jwtService.generateToken(userLoginDTO.email());
    }
}
