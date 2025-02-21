package com.library.management.book.exception;

public class GenreDoesNotExistsException extends RuntimeException{
    public GenreDoesNotExistsException(String msg){
        super(msg);
    }
}
