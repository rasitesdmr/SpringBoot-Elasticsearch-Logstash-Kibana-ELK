package com.example.studentlessonservice.exception;

public class NotAvailableException extends RuntimeException {
    public NotAvailableException(String message) {
        super(message);
    }
}