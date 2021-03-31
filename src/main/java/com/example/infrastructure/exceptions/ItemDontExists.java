package com.example.infrastructure.exceptions;

public class ItemDontExists extends RuntimeException{
    public ItemDontExists(String message) {
        super(message);
    }
}
