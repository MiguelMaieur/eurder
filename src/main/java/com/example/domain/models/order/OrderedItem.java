package com.example.domain.models.order;

import java.time.LocalDate;
import java.util.UUID;

public class OrderedItem {
    private final UUID orderId;
    private final UUID groupId;
    private final UUID memberId;
    private final UUID itemId;
    private final int amount;
    private final LocalDate shippingDate;
    private final Double totalAmount;

    public OrderedItem(UUID orderId, UUID groupId, UUID memberId, UUID itemId, int amount, LocalDate shippingDate, Double totalAmount) {
        this.orderId = orderId;
        this.groupId = groupId;
        this.memberId = memberId;
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.totalAmount = totalAmount;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
}
