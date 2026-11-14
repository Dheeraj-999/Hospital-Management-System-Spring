package com.example.hms.service;

import com.example.hms.config.JwtService;
import com.example.hms.dto.AuthRequest;
import com.example.hms.dto.AuthResponse;
import com.example.hms.dto.RegisterRequest;
import com.example.hms.entity.Role;
import com.example.hms.entity.User;
import com.example.hms.exception.UserAlreadyExistsException;
import com.example.hms.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // Constructor injection for required dependencies
    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // Register a new patient account
    public User register(RegisterRequest request) {

        // Prevent registration with an email that already exists.
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email is already registered");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Encrypt the password before saving it
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Assign PATIENT role to every public registration
        user.setRole(Role.PATIENT);

        return userRepository.save(user);
    }

    // Authenticate an existing user and generate a JWT
    public AuthResponse login(AuthRequest request) {

        // Verify email and password using Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Retrieve the authenticated user from the database
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new IllegalArgumentException("User not found"));

        // Generate a JWT token for the authenticated user
        String token = jwtService.generateToken(user.getEmail());

        // Return the token and basic user information
        return new AuthResponse(
                token,
                user.getEmail(),
                user.getRole().name()
        );
    }
}