package com.example.api.dto.item;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateItemDTO {
    private String name;
    private String description;
    private Double price;
    private int amount;

    public UpdateItemDTO() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public UpdateItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public UpdateItemDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public UpdateItemDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public UpdateItemDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
