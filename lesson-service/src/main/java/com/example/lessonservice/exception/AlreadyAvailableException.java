package com.example.lessonservice.exception;


public class AlreadyAvailableException extends RuntimeException{
    public AlreadyAvailableException(String message) {
        super(message);
    }
}
