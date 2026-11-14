
package com.example.hms.controller;

import com.example.hms.entity.Patient;
import com.example.hms.service.PatientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Handles all patient management API requests.
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    // Constructor injection.
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // API 1: Add a new patient.
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }

    // API 2: Get all patients.
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // API 3: Get a patient by ID.
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    // API 4: Update patient details.
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Long id,
            @RequestBody Patient patient) {

        return ResponseEntity.ok(
                patientService.updatePatient(id, patient)
        );
    }

    // API 5: Delete a patient.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
