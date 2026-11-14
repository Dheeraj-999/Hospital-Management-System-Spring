# Hospital Management System

A beginner-friendly Hospital Management System built using **Java, Spring Boot, Spring Security, JWT, Spring Data JPA, and MySQL**.

This project provides a secure REST API that allows users to register, log in, and manage patient records. It demonstrates important backend development concepts such as REST APIs, authentication, authorization, database operations, DTOs, input validation, and exception handling.

---

## 1. Project Overview

The Hospital Management System is a backend application designed to manage patient information securely.

The project is divided into two main functional modules:

### 1. Authentication Module

This module manages user registration, login, and security.

Features:
- Register a new user.
- Login using email and password.
- Encrypt passwords using BCrypt.
- Generate JWT (JSON Web Token) after successful login.
- Validate JWT tokens for protected API requests.
- Restrict access to protected endpoints.

### 2. Patient Management Module

This module manages patient records.

Features:
- Add a new patient.
- View all patients.
- View a patient using their ID.
- Update patient information.
- Delete a patient record.
- Validate patient input.
- Handle errors such as patient records not being found.

---

## 2. Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot | Backend application framework |
| Spring Web | Creating REST APIs |
| Spring Security | Securing application endpoints |
| JWT | Token-based authentication |
| Spring Data JPA | Database operations |
| Hibernate | ORM implementation |
| MySQL | Relational database |
| Maven | Dependency management and build tool |
| Lombok | Reducing boilerplate code where used |
| Postman | API testing |
| Git & GitHub | Version control |

---

## 3. Project Architecture

The application follows a layered architecture. Each layer has a specific responsibility.

```text
Client (Postman)
       |
       v
Controller Layer
       |
       v
Service Layer
       |
       v
Repository Layer
       |
       v
MySQL Database
```

### Understanding Each Layer

**Controller Layer**
- Receives HTTP requests.
- Calls the appropriate service methods.
- Returns HTTP responses.

**Service Layer**
- Contains the application's business logic.
- Processes requests received from controllers.
- Communicates with repositories.

**Repository Layer**
- Communicates with the database.
- Uses Spring Data JPA for CRUD operations.

**Entity Layer**
- Represents database tables using Java classes.

**DTO Layer**
- Transfers data between the client and application.
- Helps separate API request/response data from database entities.

**Config Layer**
- Contains Spring Security and JWT configuration.

**Exception Layer**
- Handles validation errors and application exceptions.

---

## 4. Project Structure

```text
hospital-management-system/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/hms/
│   │   │   │
│   │   │   ├── config/
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   ├── JwtAuthenticationFilter.java
│   │   │   │   └── JwtService.java
│   │   │   │
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java
│   │   │   │   └── PatientController.java
│   │   │   │
│   │   │   ├── dto/
│   │   │   │   ├── AuthRequest.java
│   │   │   │   ├── AuthResponse.java
│   │   │   │   └── PatientDto.java
│   │   │   │
│   │   │   ├── entity/
│   │   │   │   ├── User.java
│   │   │   │   ├── Role.java
│   │   │   │   └── Patient.java
│   │   │   │
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java
│   │   │   │   └── PatientRepository.java
│   │   │   │
│   │   │   ├── service/
│   │   │   │   ├── AuthService.java
│   │   │   │   ├── PatientService.java
│   │   │   │   ├── PatientMapper.java
│   │   │   │   └── CustomUserDetailsService.java
│   │   │   │
│   │   │   ├── exception/
│   │   │   │   ├── ResourceNotFoundException.java
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │   │
│   │   │   └── HospitalManagementSystemApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── .env
├── .gitignore
├── pom.xml
└── README.md
```

*Note: This structure describes the application's main components. The exact files may evolve as development progresses.*

---

## 5. Database Design

The application uses MySQL and contains two main tables.

### Users Table

Stores registered user information.

| Column | Description |
|---|---|
| id | Unique user ID |
| name | User's name |
| email | User's email address |
| password | BCrypt-encrypted password |
| role | User role |

### Patients Table

Stores patient information.

| Column | Description |
|---|---|
| id | Unique patient ID |
| name | Patient's name |
| email | Patient's email address |
| phone | Patient's phone number |
| date_of_birth | Patient's date of birth |
| gender | Patient's gender |
| address | Patient's address |

Hibernate automatically creates or updates the database tables using the configured JPA settings.

---

## 6. Development Journey – Git Feature Branches

The project was developed incrementally using a GitFlow-based workflow.

Each feature was developed in a separate feature branch and integrated into the `develop` branch.

### UC1 – User and Role Management

**Objective:** Establish the basic user structure and role management.

**What we implemented:**
- Created the `User` entity.
- Created the `Role` enum.
- Defined two roles: `ADMIN` and `PATIENT`.
- Added user information such as ID, name, email, password, and role.
- Created `UserRepository`.
- Added repository support for finding users by email and checking whether an email already exists.

**Concepts learned:**
- Java enums.
- JPA entities.
- Repository interfaces.
- Database mapping.
- Spring Data JPA.

### UC2 – User Authentication and JWT

**Objective:** Implement secure registration and login.

**What we implemented:**
- Created user registration API.
- Created user login API.
- Implemented password encryption using BCrypt.
- Implemented authentication using Spring Security.
- Created `JwtService` for token generation and validation.
- Created `JwtAuthenticationFilter` to process JWT tokens.
- Implemented `SecurityConfig`.
- Created authentication request and response DTOs.
- Added `CustomUserDetailsService`.
- Configured public authentication endpoints and protected application endpoints.

**Concepts learned:**
- Authentication and authorization.
- Password hashing.
- JWT generation and validation.
- Spring Security filter chain.
- Stateless authentication.
- Dependency injection.

### UC3 – Patient Management CRUD

**Objective:** Implement patient record management.

**What we implemented:**
- Created the `Patient` entity.
- Created `PatientRepository`.
- Implemented `PatientService`.
- Created `PatientController`.
- Added API to create a patient.
- Added API to retrieve all patients.
- Added API to retrieve a patient by ID.
- Added API to update patient information.
- Added API to delete a patient.
- Secured patient endpoints using JWT authentication.

**Concepts learned:**
- CRUD operations.
- REST API development.
- HTTP methods.
- Spring Data JPA.
- Controller-Service-Repository architecture.
- Protected REST endpoints.

### UC4 – DTO Implementation

**Objective:** Separate API data transfer objects from database entities.

**What we implemented:**
- Created `PatientDto`.
- Created `PatientMapper`.
- Implemented entity-to-DTO conversion.
- Implemented DTO-to-entity conversion.
- Updated `PatientService` to work with DTOs.
- Updated `PatientController` to accept and return DTO objects.
- Kept database entities separate from API request and response structures.

**Concepts learned:**
- Data Transfer Objects.
- Entity mapping.
- Separation of concerns.
- Cleaner API design.
- Stream API for converting patient lists.

### UC5 – Input Validation and Exception Handling

**Objective:** Improve API reliability by validating user input and handling errors properly.

**What we implemented:**
- Added validation annotations to `PatientDto`.
- Added `@NotBlank` to required text fields.
- Added `@Size` to validate patient name length.
- Added `@Email` to validate email format.
- Added `@Pattern` to validate the 10-digit phone number.
- Added `@NotNull` and `@Past` to validate date of birth.
- Added `@Valid` to patient creation and update requests.
- Created `ResourceNotFoundException`.
- Created `GlobalExceptionHandler` using `@RestControllerAdvice`.
- Configured validation errors to return HTTP 400.
- Configured missing patient records to return HTTP 404.

**Concepts learned:**
- Bean Validation.
- Validation annotations.
- Custom exceptions.
- Global exception handling.
- HTTP status codes.
- Spring Boot error handling.

### UC6 – JWT Security Verification and Final Integration

**Objective:** Complete the final security verification, testing, and documentation.

**Final activities:**
- Verify registration and login functionality.
- Verify JWT generation and validation.
- Verify access to protected patient endpoints.
- Test requests with missing, invalid, and valid tokens.
- Verify that authentication failures return HTTP 401.
- Re-test all patient CRUD endpoints.
- Verify validation and exception responses.
- Run Maven tests and package the application.
- Complete project documentation.
- Integrate the completed feature work into the `develop` branch.

**Concepts reinforced:**
- JWT authentication flow.
- Spring Security.
- API integration testing.
- Maven build lifecycle.
- GitFlow integration.

*UC6 is the final verification and integration stage; individual checks should be marked complete only after they have been tested successfully.*

---

## 7. API Documentation

Base URL:

```text
http://localhost:8083
```

### Authentication APIs

| Method | Endpoint | Description | Access |
|---|---|---|---|
| POST | `/api/auth/register` | Register a new user | Public |
| POST | `/api/auth/login` | Login and receive JWT | Public |

**Registration request example:**

```json
{
  "name": "Rahul Sharma",
  "email": "rahul@gmail.com",
  "password": "Rahul@123"
}
```

**Login request example:**

```json
{
  "email": "rahul@gmail.com",
  "password": "Rahul@123"
}
```

After successful login, the application returns a JWT token.

Use this token when accessing protected patient APIs.

### Patient Management APIs

| Method | Endpoint | Description | Access |
|---|---|---|---|
| POST | `/api/patients` | Add a new patient | JWT Required |
| GET | `/api/patients` | Get all patients | JWT Required |
| GET | `/api/patients/{id}` | Get patient by ID | JWT Required |
| PUT | `/api/patients/{id}` | Update patient | JWT Required |
| DELETE | `/api/patients/{id}` | Delete patient | JWT Required |

**Example patient request:**

```json
{
  "name": "Rahul Sharma",
  "email": "rahul@gmail.com",
  "phone": "9876543210",
  "dateOfBirth": "2002-05-15",
  "gender": "Male",
  "address": "Chennai, Tamil Nadu"
}
```

### How to Send JWT in Postman

For protected patient APIs:

1. Open the request in Postman.
2. Select the Authorization tab.
3. Choose Bearer Token.
4. Paste the JWT received from login.
5. Send the request.

The token is used by Spring Security to authenticate the request.

---

## 8. HTTP Status Codes

| Status Code | Meaning |
|---|---|
| 200 OK | Request completed successfully |
| 201 Created | Resource created successfully |
| 400 Bad Request | Invalid input or validation failure |
| 401 Unauthorized | Missing or invalid authentication |
| 404 Not Found | Requested patient does not exist |
| 409 Conflict | Duplicate user registration, where handled |
| 500 Internal Server Error | Unexpected server-side error |

---

## 9. Prerequisites

Before running this project, install:

- Java JDK 21
- MySQL Server 8.0 or compatible version
- Maven
- IntelliJ IDEA or Visual Studio Code
- Postman
- Git

Verify Java and Maven:

```powershell
java -version
mvn -version
```

---

## 10. Database Setup

Open MySQL and execute:

```sql
CREATE DATABASE hospital_db;
```

The application uses this database:

```text
hospital_db
```

Hibernate creates or updates the required tables when the application starts, based on the JPA configuration.

---

## 11. Environment Configuration

The application uses environment variables to protect sensitive configuration.

Create a `.env` file in the project root:

```env
DB_URL=jdbc:mysql://localhost:3306/hospital_db
DB_USERNAME=root
DB_PASSWORD=your_mysql_password
JWT_SECRET=your_base64_encoded_jwt_secret
```

**Important:**
- Replace the example values with your own configuration.
- Never upload `.env` to GitHub.
- Never expose your database password or JWT secret.
- The `.env` file is excluded using `.gitignore`.

Spring Boot does not automatically load `.env` files. In PowerShell, load the variables before running the application:

```powershell
Get-Content .env | Where-Object { $_ -match '^\s*[^#][^=]*=' } | ForEach-Object {
    $key, $value = $_.Split('=', 2)
    [Environment]::SetEnvironmentVariable($key.Trim(), $value.Trim(), 'Process')
}
```

---

## 12. How to Run the Project

**Step 1: Clone the repository**

```powershell
git clone https://github.com/Dheeraj-999/Hospital-Management-System-Spring.git
```

**Step 2: Open the project**

```powershell
cd Hospital-Management-System-Spring
```

**Step 3: Switch to the development branch**

The application source code is maintained in `develop`.

```powershell
git switch develop
git pull origin develop
```

**Step 4: Load environment variables**

Use the PowerShell environment-loading command from Section 11.

**Step 5: Build the project**

```powershell
mvn clean install
```

**Step 6: Run the application**

```powershell
mvn spring-boot:run
```

The application runs at:

```text
http://localhost:8083
```

**Step 7: Test APIs**

Open Postman and test the authentication and patient management endpoints described above.

---

## 13. Git Branching Strategy

This project follows a GitFlow-inspired development workflow.

| Branch | Purpose |
|---|---|
| `main` | Project documentation (README) |
| `develop` | Integrated application source code |
| `feature/user-role-management` | UC1 |
| `feature/user-authentication-jwt` | UC2 |
| `feature/patient-management` | UC3 |
| `feature/patient-dto` | UC4 |
| `feature/validation-exception-handling` | UC5 |
| `feature/final-integration` | UC6 |

Each feature was developed independently and integrated into `develop` after implementation.

The `main` branch is intentionally maintained for project documentation, while `develop` contains the application code.

---

## 14. Learning Outcomes

Through this project, the following backend development concepts were practiced:

- Building REST APIs using Spring Boot.
- Understanding layered application architecture.
- Working with Java entities and enums.
- Connecting Java applications to MySQL.
- Performing CRUD operations using Spring Data JPA.
- Implementing authentication using Spring Security.
- Generating and validating JWT tokens.
- Securing REST endpoints.
- Using BCrypt password encryption.
- Implementing DTOs and entity mapping.
- Applying input validation.
- Handling exceptions globally.
- Testing APIs using Postman.
- Managing project development using Git and GitFlow.
- Building applications using Maven.

---

## 15. Future Enhancements

The current project is intentionally limited to authentication and patient management.

Possible future improvements, if required, include:
- Adding automated integration tests.
- Adding API documentation using Swagger/OpenAPI.
- Adding a frontend application.
- Deploying the backend to a cloud platform.

These are optional enhancements and are not part of the current project scope.

---

## 16. Author

**Dheeraj**

GitHub: [Dheeraj-999](https://github.com/Dheeraj-999)

---

**Project:** Hospital Management System  
**Backend:** Spring Boot  
**Database:** MySQL  
**Language:** Java 21  
**Build Tool:** Maven

