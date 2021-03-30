package com.example.api.mappers;

import com.example.api.dto.item.OrderItemDTO;
import com.example.api.dto.item.OrderedItemsDTO;
import com.example.domain.models.order.OrderedItem;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    private final UserService userService;
    private final OrderService orderService;

    public OrderMapper(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    public OrderedItemsDTO itemsToOrderedItemsDTO(UUID groupId, UUID userId) {
        var orderList = orderService.getOrdersByGroupId(groupId);

        return new OrderedItemsDTO().setUser(userService.getUserById(userId))
                .setItemList(getItemslist(orderList))
                .setTotalPrice(getTotalPrice(orderList))
                .setGroupId(groupId);
    }

    private Double getTotalPrice(Collection<OrderedItem> orderList) {
        return orderList.stream().mapToDouble(OrderedItem::getTotalAmount).sum();
    }

    private Collection<OrderItemDTO> getItemslist(Collection<OrderedItem> orderList) {
        return orderList.stream().map(c -> new OrderItemDTO().setId(c.getItemId()).setAmount(c.getAmount()).setShippingdate(c.getShippingDate())).collect(Collectors.toList());
    }
}