package com.example.domain.repository;

import com.example.domain.models.order.OrderedItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    private final List<OrderedItem> itemList;

    public OrderRepository() {
        itemList = new ArrayList<>();
    }

    public OrderedItem addOrder(OrderedItem order) {
        itemList.add(order);
        return order;
    }

    public List<OrderedItem> getAllOrders() {
        return itemList;
    }
}
