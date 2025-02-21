package com.library.management.book.exception;

import com.library.management.library.exception.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalBookExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //To handle exceptions when author name is not found
    @ExceptionHandler(AuthorDoesNotExistException.class)
    public ResponseEntity<String> handleAuthorDoesNotExistException(AuthorDoesNotExistException msg){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg.getMessage());
    }

    //To handle exceptions when book input has some issues
    @ExceptionHandler(BookExistsCheckException.class)
    public ResponseEntity<String> handleBookDoesNotExistsException(BookExistsCheckException msg){
        if(msg.toString().contains("not"))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg.getMessage());
        else
            return ResponseEntity.status(HttpStatus.CONFLICT).body(msg.getMessage());
    }

    //To handle all other type of exceptions. Logs error, while response contains only a short message
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllOtherExceptions(Exception msg){

        log.error("Error encountered: ", msg);
//        msg.printStackTrace();

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Sorry, error encountered");
    }

}
