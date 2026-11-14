# Hospital-Management-System-Spring

# UC2 – User Authentication and JWT

## Objective
To implement secure user registration and login using Spring Security and JWT.

## Features Implemented
- Created user registration API.
- Created user login API.
- Implemented BCrypt password encryption.
- Configured Spring Security.
- Implemented JWT generation.
- Implemented JWT token validation.
- Created JwtAuthenticationFilter.
- Created JwtService.
- Configured public authentication endpoints.
- Secured other application endpoints.
- Implemented CustomUserDetailsService.
- Created authentication request and response DTOs.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/auth/register | Register user |
| POST | /api/auth/login | Login user |

## Main Files
- config/SecurityConfig.java
- config/JwtService.java
- config/JwtAuthenticationFilter.java
- service/AuthService.java
- service/CustomUserDetailsService.java
- controller/AuthController.java
- dto/AuthRequest.java
- dto/AuthResponse.java

## Concepts Learned
- Authentication and authorization
- BCrypt password hashing
- JWT generation and validation
- Spring Security
- Security filter chain
- Stateless authentication

## Outcome
Implemented the authentication foundation and JWT-based protection for secured APIs.
