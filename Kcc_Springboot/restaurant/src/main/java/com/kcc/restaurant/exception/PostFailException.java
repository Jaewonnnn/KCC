package com.kcc.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostFailException extends RuntimeException{
    public PostFailException(String message) {
        super(message);
    }
}