
package com.example.hms.service;

import com.example.hms.entity.Patient;
import com.example.hms.repository.PatientRepository;

import org.springframework.stereotype.Service;

import java.util.List;

// Contains the business logic for patient management.
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    // Constructor injection.
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Add a new patient.
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Retrieve all patients.
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Retrieve a patient by ID.
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Patient not found with ID: " + id));
    }

    // Update an existing patient's details.
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient existingPatient = getPatientById(id);

        existingPatient.setName(updatedPatient.getName());
        existingPatient.setEmail(updatedPatient.getEmail());
        existingPatient.setPhone(updatedPatient.getPhone());
        existingPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
        existingPatient.setGender(updatedPatient.getGender());
        existingPatient.setAddress(updatedPatient.getAddress());

        return patientRepository.save(existingPatient);
    }

    // Delete a patient by ID.
    public void deletePatient(Long id) {
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }
}
