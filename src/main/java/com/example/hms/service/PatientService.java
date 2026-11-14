
package com.example.hms.service;

import com.example.hms.dto.PatientDto;
import com.example.hms.entity.Patient;
import com.example.hms.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository,
                          PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    // Add a patient using DTO
    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = patientMapper.toEntity(patientDto);
        patient.setId(null); // Let the database generate the ID

        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toDto(savedPatient);
    }

    // Get all patients as DTOs
    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toDto)
                .toList();
    }

    // Get patient by ID
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Patient not found with ID: " + id));

        return patientMapper.toDto(patient);
    }

    // Update patient details
    public PatientDto updatePatient(Long id, PatientDto updatedDto) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Patient not found with ID: " + id));

        existingPatient.setName(updatedDto.getName());
        existingPatient.setEmail(updatedDto.getEmail());
        existingPatient.setPhone(updatedDto.getPhone());
        existingPatient.setDateOfBirth(updatedDto.getDateOfBirth());
        existingPatient.setGender(updatedDto.getGender());
        existingPatient.setAddress(updatedDto.getAddress());

        Patient savedPatient = patientRepository.save(existingPatient);
        return patientMapper.toDto(savedPatient);
    }

    // Delete patient
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Patient not found with ID: " + id));

        patientRepository.delete(patient);
    }
}
