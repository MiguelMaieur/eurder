package com.example.infrastructure.exceptions;

public class Unauthorized extends RuntimeException{
    public Unauthorized(String message){
        super(message);
    }
}
