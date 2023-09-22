package com.myEcommerce.product.CustomException;

import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException extends Exception {
    public NoSuchElementFoundException(String message) {
        super(message);
    }

}
