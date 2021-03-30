package com.example.api.dto.item;

import com.example.domain.models.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderedItemsDTO {
    private Collection<OrderItemDTO> itemList;
    private Double totalPrice;
    private User user;
    private LocalDate orderDate;
    private UUID groupId;

    public OrderedItemsDTO() {
        orderDate = LocalDate.now();
    }

    public Collection<OrderItemDTO> getItemList() {
        return itemList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public User getUser() {
        return user;
    }

    public UUID getGroupId() {
        return groupId;
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

    public OrderedItemsDTO setUser(User user) {
        this.user = user;
        return this;
    }

    public OrderedItemsDTO setGroupId(UUID groupId) {
        this.groupId = groupId;
        return this;
    }
}
