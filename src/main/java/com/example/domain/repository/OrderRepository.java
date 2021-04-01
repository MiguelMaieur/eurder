package com.example.domain.repository;

import com.example.domain.models.order.OrderedItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepository {
    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    private final List<OrderedItem> orderList;

    public OrderRepository() {
        orderList = new ArrayList<>();
        innit();
    }

    private void innit(){
        orderList.add(new OrderedItem(UUID.randomUUID(), UUID.fromString("bf61fe8a-6ca0-44dc-b529-06c98cd8b751"), UUID.fromString("5188190a-e994-40bb-a637-0140851f9728")
                , UUID.fromString("0852a3b6-0a61-4487-9a2a-f47f0a1af0f8"), 5
                , LocalDate.now(), 150.0, LocalDate.now()));

        orderList.add(new OrderedItem(UUID.randomUUID(), UUID.fromString("bf61fe8a-6ca0-44dc-b529-06c98cd8b751"), UUID.fromString("5188190a-e994-40bb-a637-0140851f9728")
                , UUID.fromString("b1a7946d-8371-4cbf-97f4-e8c525aa819c"), 15
                , LocalDate.now(), 333.0, LocalDate.now()));

        orderList.add(new OrderedItem(UUID.randomUUID(), UUID.fromString("559e3c03-a781-45f4-afcf-8a6f94af187f"), UUID.fromString("5188190a-e994-40bb-a637-0140851f9728")
                , UUID.fromString("b4e7f7e4-d57d-4813-9da6-0a3fb938405d"), 7
                , LocalDate.now(), 217.0, LocalDate.now()));

        orderList.add(new OrderedItem(UUID.randomUUID(), UUID.fromString("cd82f039-7957-4f78-b605-a855a94f27f1"), UUID.fromString("5188190a-e994-40bb-a637-0140851f9728")
                , UUID.fromString("5130a4d2-996b-4fa9-bb53-bb0ae2543d53"), 12
                , LocalDate.now().plusDays(7), 325.0, LocalDate.now()));

        orderList.add(new OrderedItem(UUID.randomUUID(), UUID.fromString("cd82f039-7957-4f78-b605-a855a94f27f1"), UUID.fromString("5188190a-e994-40bb-a637-0140851f9728")
                , UUID.fromString("b1a7946d-8371-4cbf-97f4-e8c525aa819c"), 5
                , LocalDate.now(), 1293.25, LocalDate.now()));
    }

    public OrderedItem addOrder(OrderedItem order) {
        orderList.add(order);
        return order;
    }

    public Collection<OrderedItem> getAllOrders() {
        return orderList;
    }
}
