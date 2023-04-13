package com.example.studentlessonservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NotAvailableException.class)
    public ResponseEntity<?> handel(NotAvailableException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND); // 404
    }

}
