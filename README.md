# Hospital-Management-System-Spring

# UC4 – Patient DTO Implementation

## Objective
To separate API request and response data from database entities.

## Features Implemented
- Created PatientDto.
- Created PatientMapper.
- Implemented conversion from DTO to entity.
- Implemented conversion from entity to DTO.
- Updated PatientService to use PatientDto.
- Updated PatientController to accept and return DTO objects.
- Kept database entities separate from API data structures.

## Main Files
- dto/PatientDto.java
- service/PatientMapper.java
- service/PatientService.java
- controller/PatientController.java

## Concepts Learned
- Data Transfer Objects
- Entity mapping
- Separation of concerns
- Cleaner API design
- Java Stream API

## Outcome
Patient APIs were refactored to use DTOs instead of directly exposing entity objects.
