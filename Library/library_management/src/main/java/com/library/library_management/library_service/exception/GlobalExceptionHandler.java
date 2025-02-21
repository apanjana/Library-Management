package com.library.library_management.library_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LibraryIdExistsException.class)
    public ResponseEntity<String> handleLibraryIdExistsException(LibraryIdExistsException msg){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg.getMessage());
    }

    @ExceptionHandler(LibraryLocationExistsException.class)
    public ResponseEntity<String> handleLibraryLocationExistsException(LibraryLocationExistsException msg){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg.getMessage());
    }
}
