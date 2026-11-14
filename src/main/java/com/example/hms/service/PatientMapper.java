package com.example.hms.service;

import com.example.hms.dto.PatientDto;
import com.example.hms.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    // Convert PatientDto into Patient Entity
    public Patient toEntity(PatientDto dto) {
        Patient patient = new Patient();

        patient.setId(dto.getId());
        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setPhone(dto.getPhone());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setGender(dto.getGender());
        patient.setAddress(dto.getAddress());

        return patient;
    }

    // Convert Patient Entity into PatientDto
    public PatientDto toDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getDateOfBirth(),
                patient.getGender(),
                patient.getAddress()
        );
    }
}