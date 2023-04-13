package com.example.client.exception;

public class AlreadyAvailableException extends RuntimeException{
    public AlreadyAvailableException(String message) {
        super(message);
    }
}
