package com.example.api.dto.item;

import java.util.List;

public class OrderItemDTOWrapper {
    private List<OrderItemDTO> items;

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
