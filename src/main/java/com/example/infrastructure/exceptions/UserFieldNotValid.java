package com.example.infrastructure.exceptions;

public class UserFieldNotValid extends RuntimeException{
    public UserFieldNotValid(String message){
        super(message);
    }
}
