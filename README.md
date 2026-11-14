# Hospital-Management-System-Spring

# UC3 – Patient Management CRUD

## Objective
To implement patient record management using REST APIs.

## Features Implemented
- Created Patient entity.
- Created PatientRepository.
- Implemented PatientService.
- Created PatientController.
- Implemented adding a patient.
- Implemented retrieving all patients.
- Implemented retrieving a patient by ID.
- Implemented updating patient information.
- Implemented deleting a patient.
- Secured patient APIs using JWT authentication.

## Patient Information
- ID
- Name
- Email
- Phone
- Date of Birth
- Gender
- Address

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/patients | Add patient |
| GET | /api/patients | Get all patients |
| GET | /api/patients/{id} | Get patient by ID |
| PUT | /api/patients/{id} | Update patient |
| DELETE | /api/patients/{id} | Delete patient |

## Main Files
- entity/Patient.java
- repository/PatientRepository.java
- service/PatientService.java
- controller/PatientController.java

## Concepts Learned
- REST API development
- CRUD operations
- HTTP methods
- Spring Data JPA
- Layered architecture
- JWT-protected endpoints

## Outcome
Implemented the complete patient CRUD functionality.
