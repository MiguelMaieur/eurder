package com.example.api.dto.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "orderid", "orderDate" })
public class OrderedItemsDTO {
    private UUID orderid;
    private final LocalDate orderDate;
    @JsonPropertyOrder({"fullName", "Street","postalCode","city"})
    private DeliveryAddress deliveryAddress;
    private Collection<OrderItemDTO> itemList;
    private Double totalPrice;

    public OrderedItemsDTO() {
        orderDate = LocalDate.now();
    }

    public Collection<OrderItemDTO> getItemList() {
        return itemList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public UUID getOrderId() {
        return orderid;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderedItemsDTO setItemList(Collection<OrderItemDTO> itemList) {
        this.itemList = itemList;
        return this;
    }

    public OrderedItemsDTO setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public OrderedItemsDTO setdeliveryAddress(DeliveryAddress address) {
        this.deliveryAddress = address;
        return this;
    }

    public OrderedItemsDTO setOrderId(UUID orderId) {
        this.orderid = orderId;
        return this;
    }
}
