package com.example.api.dto.order;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDTO {
    private UUID id;
    private int amount;
    private LocalDate shippingDate;

    public OrderItemDTO() {
    }

    public UUID getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingdate() {
        return shippingDate;
    }

    public OrderItemDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public OrderItemDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public OrderItemDTO setShippingdate(LocalDate shippingdate) {
        this.shippingDate = shippingdate;
        return this;
    }
}
