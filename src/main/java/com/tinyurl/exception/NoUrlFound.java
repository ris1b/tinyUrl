package com.tinyurl.exception;

public class NoUrlFound extends RuntimeException{

    public NoUrlFound(String message){
        super(message);
    }
}
