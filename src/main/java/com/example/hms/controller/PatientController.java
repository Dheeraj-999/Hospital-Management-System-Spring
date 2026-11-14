
package com.example.hms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// This controller contains protected patient APIs.
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    // This endpoint requires a valid JWT token.
    @GetMapping("/test")
    public Map<String, String> testPatientAccess() {
        return Map.of(
                "message", "JWT authentication successful!",
                "status", "You have accessed a protected API"
        );
    }
}
