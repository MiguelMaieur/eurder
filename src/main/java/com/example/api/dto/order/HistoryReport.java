package com.example.api.dto.order;

import com.example.domain.models.order.OrderedItem;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HistoryReport {
    private Map.Entry<UUID, List<OrderedItem>> order;
    private Double totalPrice = 0.0;

    public HistoryReport() {
    }

    public void fillInPrice() {
        for (var x : order.getValue()) {
            totalPrice += x.getTotalAmount();
        }
    }

    public Map.Entry<UUID, List<OrderedItem>> getOrder() {
        return order;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public HistoryReport setRow(Map.Entry<UUID, List<OrderedItem>> order) {
        this.order = order;
        fillInPrice();
        return this;
    }
}
