package com.example.infrastructure.exceptions;

public class ItemFieldNotValidException extends RuntimeException{
    public ItemFieldNotValidException(String message){
        super(message);
    }
}
