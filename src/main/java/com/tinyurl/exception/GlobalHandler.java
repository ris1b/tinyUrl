package com.tinyurl.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(value = NoUrlFound.class)
    public String noUrlFound(NoUrlFound noUrlFound){
        return noUrlFound.getMessage();
    }
}
