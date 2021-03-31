package com.example.api.controllers;

import com.example.api.dto.order.HistoryReportDTO;
import com.example.api.dto.order.OrderItemDTOWrapper;
import com.example.api.dto.order.OrderedItemsDTO;
import com.example.api.dto.order.ReOrderDTO;
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
    public OrderedItemsDTO orderItems(@RequestBody OrderItemDTOWrapper wrapper, @RequestHeader("Authorization") UUID userid) {
        if (!userService.isUserInRoleUser(userid)) {
            logger.warn("Someone tried to order items without a valid memberId; id used : " + userid);
            throw new Unauthorized("You are not authorized to order a item.");
        }
        return orderMapper.itemsToOrderedItemsDTO(orderService.saveOrders(wrapper.getItems(), userid), userid);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public HistoryReportDTO getReportOfOrders(@RequestHeader("Authorization") UUID userid) {
        if (!userService.isUserInRoleUser(userid)) {
            logger.warn("Someone tried to see the orders of a member without a valid memberId; id used : " + userid);
            throw new Unauthorized("You are not authorized see the order history.");
        }
        return orderMapper.mapToHistoryReportDTO(orderService.getOrderHistory(userid));
    }

    @PostMapping(path = "/{groupId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ReOrderDTO reOrder(@PathVariable UUID groupId, @RequestHeader("Authorization") UUID userid) {
        if (!userService.isUserInRoleUser(userid)) {
            logger.warn("Someone tried to reorder a order without a valid memberId; id used : " + userid);
            throw new Unauthorized("You are not authorized to reorder a order.");
        }
        return orderMapper.uuidToReOrderDTO(orderService.reOrder(groupId, userid));
    }
}
