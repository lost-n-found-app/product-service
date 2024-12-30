package com.LostAndFound.ProductService.exception;

public class UserNotFoundException extends RuntimeException{

    // Default constructor
    public UserNotFoundException() {
        super("User not found");
    }

    // Constructor that accepts a custom error message
    public UserNotFoundException(String message) {
        super(message);
    }

    // Constructor that accepts a custom message and the cause of the exception
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    // Optional: Override toString() to provide more detailed exception info
    @Override
    public String toString() {
        return "UserNotFoundException: " + getMessage();
    }

}
