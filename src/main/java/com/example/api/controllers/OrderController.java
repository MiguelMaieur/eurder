package com.example.api.controllers;

import com.example.api.dto.item.OrderItemDTOWrapper;
import com.example.api.dto.item.OrderedItemsDTO;
import com.example.api.mappers.OrderMapper;
import com.example.infrastructure.exceptions.Unauthorized;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final UserService userService;
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(UserService userService, OrderService orderService, OrderMapper orderMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderedItemsDTO OrderItems(@RequestBody OrderItemDTOWrapper wrapper, @RequestHeader("Authorization") UUID userid) {
        if (!userService.isUserInRoleUser(userid)) {
            logger.warn("Someone tried to order items without a valid memberId; id used : " + userid);
            throw new Unauthorized("You are not authorized to order a item.");
        }
        return orderMapper.itemsToOrderedItemsDTO(orderService.saveOrders(wrapper.getItems(), userid), userid);
    }
}
