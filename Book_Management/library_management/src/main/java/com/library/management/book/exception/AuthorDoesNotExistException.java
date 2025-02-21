package com.library.management.book.exception;

public class AuthorDoesNotExistException extends RuntimeException{
    public AuthorDoesNotExistException(String msg){
        super(msg);
    }
}
