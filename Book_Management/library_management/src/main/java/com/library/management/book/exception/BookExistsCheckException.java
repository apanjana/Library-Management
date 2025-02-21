package com.library.management.book.exception;

public class BookExistsCheckException extends RuntimeException{
    public BookExistsCheckException(String msg){
        super(msg);
    }
}
