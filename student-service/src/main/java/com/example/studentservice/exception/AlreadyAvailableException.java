package com.example.studentservice.exception;

public class AlreadyAvailableException extends RuntimeException{
    public AlreadyAvailableException(String message) {
        super(message);
    }
}
