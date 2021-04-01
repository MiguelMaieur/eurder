package com.example.api.dto.shipping;

import com.example.api.dto.order.DeliveryAddress;
import com.example.domain.models.order.OrderedItem;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ShippingToDayOrder {
    private Map.Entry<UUID, List<OrderedItem>> order;
    private DeliveryAddress deliveryAddress;

    public ShippingToDayOrder() {
    }

    public Map.Entry<UUID, List<OrderedItem>> getOrder() {
        return order;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public ShippingToDayOrder setRow(Map.Entry<UUID, List<OrderedItem>> order) {
        this.order = order;
        return this;
    }

    public ShippingToDayOrder setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }
}
