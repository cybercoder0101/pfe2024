package com.pfe.code.services.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GlobalException extends RuntimeException{
    private String message;

    public GlobalException(String message) {
        super(message);
    }
}
