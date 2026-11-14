
package com.example.hms.repository;

import com.example.hms.entity.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Provides database operations for Patient entities.
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
