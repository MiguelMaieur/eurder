package com.example.domain.models.item;

import com.example.infrastructure.exceptions.UserFieldNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Item {
    private static final Logger logger = LoggerFactory.getLogger(Item.class);
    private final UUID id;
    private final String name;
    private final String description;
    private final Double price;
    private int amount;

    public Item(String name, String description, Double price, int amount) {
        this.id = UUID.randomUUID();
        this.name = validator(name, "name");
        this.description = validator(description, "description");
        this.price = validatorPrice(price);
        this.amount = validatorAmount(amount);
    }

    private String validator(String value, String field) {
        if (value == null || value.isBlank()) {
            logger.warn("The field " + field + " was not valid. value : " + value);
            throw new UserFieldNotValidException(field + " was not valid.");
        }
        return value;
    }

    private Double validatorPrice(Double value) {
        if (value == null || value < 0) {
            logger.warn("The field price was not value : " + value);
            throw new UserFieldNotValidException("price" + " was not valid.");
        }
        return value;
    }

    private int validatorAmount(int value) {
        if (value < 0) {
            logger.warn("The field amount was not value : " + value);
            throw new UserFieldNotValidException("amount" + " was not valid.");
        }
        return value;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
