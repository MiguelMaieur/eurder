package com.example.api.dto.order;

import java.time.LocalDate;
import java.util.UUID;

public class HistoryOrderDetails {
    private final UUID orderId;
    private final UUID itemId;
    private final Double amount;
    private final LocalDate shippingDate;
    private final Double totalAmount;
    private final LocalDate orderDate;

    public HistoryOrderDetails(UUID orderId, UUID itemId, Double amount, LocalDate shippingDate, Double totalAmount, LocalDate orderDate) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
