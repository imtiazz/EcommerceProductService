package com.myEcommerce.product.CustomException;

import com.myEcommerce.product.dtos.ExceptionDTOs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler  {
    @ExceptionHandler(NoSuchElementFoundException.class)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
     public ResponseEntity<ExceptionDTOs> handleNoSuchElementException(NoSuchElementFoundException ex) {
        ExceptionDTOs exceptionDTOs = new ExceptionDTOs("No element found", HttpStatus.NOT_FOUND,"imtiaz");
        return new ResponseEntity<>(exceptionDTOs, HttpStatus.NOT_FOUND);
    }
}
