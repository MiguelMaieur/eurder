package com.example.infrastructure.exceptions;

public class ItemAlreadyExitsException extends RuntimeException{
    public ItemAlreadyExitsException(String message){
        super(message);
    }
}
