
package com.example.hms.controller;

import com.example.hms.dto.PatientDto;
import com.example.hms.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientDto> addPatient(
            @RequestBody PatientDto patientDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(patientService.addPatient(patientDto));
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(
            @PathVariable Long id) {

        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(
            @PathVariable Long id,
            @RequestBody PatientDto patientDto) {

        return ResponseEntity.ok(
                patientService.updatePatient(id, patientDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(
            @PathVariable Long id) {

        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
