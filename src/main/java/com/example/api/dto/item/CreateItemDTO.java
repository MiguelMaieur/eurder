package com.example.api.dto.item;

public class CreateItemDTO {
    private String name;
    private String description;
    private Double price;
    private int amount;

    public CreateItemDTO() {
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

    public CreateItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public CreateItemDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateItemDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public CreateItemDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
