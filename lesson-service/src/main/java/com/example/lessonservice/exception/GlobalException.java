package com.example.lessonservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handel(BadRequestException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST); // 400
    }

    @ExceptionHandler(NotAvailableException.class)
    public ResponseEntity<?> handel(NotAvailableException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND); // 404
    }

    @ExceptionHandler(AlreadyAvailableException.class)
    public ResponseEntity<?> handel(AlreadyAvailableException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT); // 409
    }

}