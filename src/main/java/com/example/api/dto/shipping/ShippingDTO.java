package com.example.api.dto.shipping;

import com.example.api.dto.order.HistoryReport;
import com.example.api.dto.order.HistoryReportDTO;

import java.util.ArrayList;
import java.util.List;

public class ShippingDTO {
    private final List<ShippingToDayOrder> shippingToDayOrders;

    public ShippingDTO() {
        this.shippingToDayOrders = new ArrayList<>();
    }

    public List<ShippingToDayOrder> getShippingToDayOrders() {
        return shippingToDayOrders;
    }

    public ShippingDTO addShippingOrderToday(ShippingToDayOrder shippingToDayOrder) {
        this.shippingToDayOrders.add(shippingToDayOrder);
        return this;
    }
}
