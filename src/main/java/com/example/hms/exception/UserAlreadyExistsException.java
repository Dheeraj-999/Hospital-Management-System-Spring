
package com.example.hms.exception;

// Custom exception for duplicate email registration.
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
