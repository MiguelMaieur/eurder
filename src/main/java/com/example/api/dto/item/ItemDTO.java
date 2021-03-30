package com.example.api.dto.item;

import java.util.UUID;

public class ItemDTO {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private int amount;

    public ItemDTO() {
    }

    public UUID getId() {
        return id;
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

    public ItemDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public ItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public ItemDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
