package com.library.library_management.library_service.exception;

public class LibraryLocationExistsException extends RuntimeException {
    public LibraryLocationExistsException(String msg) {
        super(msg);
    }
}
