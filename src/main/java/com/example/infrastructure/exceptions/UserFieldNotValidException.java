package com.example.infrastructure.exceptions;

public class UserFieldNotValidException extends RuntimeException{
    public UserFieldNotValidException(String message){
        super(message);
    }
}
