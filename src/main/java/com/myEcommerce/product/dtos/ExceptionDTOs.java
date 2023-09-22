package com.myEcommerce.product.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Setter
@Getter

public class ExceptionDTOs {
    private String message;
    private HttpStatus errorCode;
    private String name;

}
