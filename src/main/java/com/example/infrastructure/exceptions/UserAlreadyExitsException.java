package com.example.infrastructure.exceptions;

public class UserAlreadyExitsException extends RuntimeException{
    public UserAlreadyExitsException(String message){
        super(message);
    }
}
