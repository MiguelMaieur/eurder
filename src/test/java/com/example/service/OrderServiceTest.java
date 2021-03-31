package com.example.service;

import com.example.api.dto.order.OrderItemDTO;
import com.example.domain.repository.ItemRepository;
import com.example.domain.repository.OrderRepository;
import com.example.infrastructure.exceptions.OrderMissingField;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    void AddAOrder() {
        //given
        OrderService orderService = new OrderService(new OrderRepository(),new ItemService(new ItemRepository()));
        List<OrderItemDTO> orderList = new ArrayList<>();
        orderList.add(new OrderItemDTO().setId(UUID.fromString("0852a3b6-0a61-4487-9a2a-f47f0a1af0f8")).setAmount(5));

        //when
        var result = orderService.saveOrders(orderList,UUID.fromString("5188190a-e994-40bb-a637-0140851f9728"));
        //then
        assertEquals(1,orderService.getOrdersByGroupId(result).size());
    }

    @Test
    void AddAOrderWithMissingAmountThrowsError() {
        //given
        OrderService orderService = new OrderService(new OrderRepository(),new ItemService(new ItemRepository()));
        List<OrderItemDTO> orderList = new ArrayList<>();
        orderList.add(new OrderItemDTO().setId(UUID.fromString("0852a3b6-0a61-4487-9a2a-f47f0a1af0f8")));

        //when
        Exception exception = assertThrows(OrderMissingField.class,() ->orderService.saveOrders(orderList,UUID.fromString("5188190a-e994-40bb-a637-0140851f9728")));
        //then
        assertEquals("There was a field missing in your order.",exception.getMessage());
    }

    @Test
    void AddAOrderWithUnknowItemThrowsError() {
        //given
        OrderService orderService = new OrderService(new OrderRepository(),new ItemService(new ItemRepository()));
        List<OrderItemDTO> orderList = new ArrayList<>();
        orderList.add(new OrderItemDTO().setId(UUID.fromString("14f2bb5e-02cc-4d07-a990-c38e72e2b4cc")).setAmount(5));

        //when
        Exception exception = assertThrows(OrderMissingField.class,() ->orderService.saveOrders(orderList,UUID.fromString("5188190a-e994-40bb-a637-0140851f9728")));
        //then
        assertEquals("There was a item id that is not known.",exception.getMessage());
    }
}