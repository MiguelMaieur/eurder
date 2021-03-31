package com.example.api.dto.order;

import java.util.UUID;

public class ReOrderDTO {
    private UUID orderId;

    public ReOrderDTO() {
    }

    public UUID getOrderId() {
        return orderId;
    }

    public ReOrderDTO setOrderId(UUID orderId) {
        this.orderId = orderId;
        return this;
    }
}
