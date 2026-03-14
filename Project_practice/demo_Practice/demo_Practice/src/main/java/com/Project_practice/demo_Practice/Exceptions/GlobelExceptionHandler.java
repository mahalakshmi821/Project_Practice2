package com.Project_practice.demo_Practice.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleException(UserNotFoundException ex){
        ErrorResponse error=new ErrorResponse(
            ex.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            LocalDateTime.now()
        );
        return ResponseEntity.ok(error);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handeleException(Exception ex){
        ErrorResponse er=new ErrorResponse(
            ex.getMessage(),
           HttpStatus.INTERNAL_SERVER_ERROR.value(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(er,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
