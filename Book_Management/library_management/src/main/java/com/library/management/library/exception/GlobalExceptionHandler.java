package com.library.management.library.exception;

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

    @ExceptionHandler(LibraryPincodeExistsException.class)
    public ResponseEntity<String> handleLibraryLocationExistsException(LibraryPincodeExistsException msg){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg.getMessage());
    }

}
