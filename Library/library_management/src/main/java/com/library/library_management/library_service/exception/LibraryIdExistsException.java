package com.library.library_management.library_service.exception;

public class LibraryIdExistsException extends RuntimeException{
    public LibraryIdExistsException(String msg){
        super(msg);
    }
}
