# Hospital-Management-System-Spring

# UC5 – Input Validation and Exception Handling

## Objective
To validate incoming patient data and provide consistent error responses.

## Features Implemented
- Added validation annotations to PatientDto.
- Added @NotBlank for required text fields.
- Added @Size for patient name validation.
- Added @Email for email validation.
- Added @Pattern for 10-digit phone validation.
- Added @NotNull and @Past for date of birth.
- Applied @Valid to patient creation and update requests.
- Created ResourceNotFoundException.
- Created GlobalExceptionHandler.
- Configured HTTP 400 responses for validation errors.
- Configured HTTP 404 responses for missing patient records.

## Main Files
- dto/PatientDto.java
- exception/ResourceNotFoundException.java
- exception/GlobalExceptionHandler.java
- service/PatientService.java
- controller/PatientController.java

## Concepts Learned
- Bean Validation
- Validation annotations
- Custom exceptions
- Global exception handling
- HTTP status codes

## Expected Error Responses

| Scenario | HTTP Status |
|---|---|
| Invalid email | 400 |
| Invalid phone number | 400 |
| Missing patient record | 404 |

## Outcome
Added input validation and centralized exception handling to improve API reliability.
