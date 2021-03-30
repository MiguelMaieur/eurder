package com.example.infrastructure.exceptions;

public class OrderMissingField extends RuntimeException{
    public OrderMissingField(String message){
        super(message);
    }
}
