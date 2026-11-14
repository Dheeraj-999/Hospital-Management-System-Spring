package com.example.hms.controller;

import com.example.hms.dto.AuthRequest;
import com.example.hms.dto.AuthResponse;
import com.example.hms.dto.RegisterRequest;
import com.example.hms.entity.User;
import com.example.hms.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    // Constructor injection of authentication service
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // API for registering a new patient
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(
            @Valid @RequestBody RegisterRequest request) {

        User user = authService.register(request);

        // Never return the user's password in the response
        Map<String, String> response = Map.of(
                "message", "User registered successfully",
                "email", user.getEmail(),
                "role", user.getRole().name()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // API for logging in an existing user
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody AuthRequest request) {

        AuthResponse response = authService.login(request);

        return ResponseEntity.ok(response);
    }
}