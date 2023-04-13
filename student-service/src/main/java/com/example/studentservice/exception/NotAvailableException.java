package com.example.studentservice.exception;

public class NotAvailableException extends RuntimeException {
    public NotAvailableException(String message) {
        super(message);
    }
}