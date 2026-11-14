# Hospital-Management-System-Spring

# UC6 – Final Integration and Security Verification

## Objective
To perform final integration checks, verify JWT security, test application functionality, and complete project documentation.

## Planned Activities
- Verify user registration.
- Verify user login.
- Verify JWT generation and validation.
- Test protected patient APIs.
- Test requests without authentication.
- Test requests with invalid tokens.
- Verify patient CRUD operations.
- Verify input validation.
- Verify custom exception handling.
- Run Maven tests.
- Build the application using Maven.
- Complete project documentation.

## Final API Verification

| Feature | Expected Result |
|---|---|
| User registration | 201 Created |
| User login | 200 OK |
| Missing JWT | 401 Unauthorized |
| Invalid JWT | 401 Unauthorized |
| Valid JWT | Access granted |
| Invalid patient input | 400 Bad Request |
| Missing patient ID | 404 Not Found |

## Build Commands

```powershell
mvn clean test
mvn clean package
```

## Concepts Reinforced
- JWT authentication flow
- Spring Security
- API integration testing
- Maven build lifecycle
- Git feature branch workflow

## Outcome
Final verification and integration of the Hospital Management System.
