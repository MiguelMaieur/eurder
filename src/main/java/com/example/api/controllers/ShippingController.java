package com.example.api.controllers;

import com.example.api.dto.shipping.ShippingDTO;
import com.example.api.mappers.ShippingMapper;
import com.example.infrastructure.exceptions.Unauthorized;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/shipping")
public class ShippingController {
    private static final Logger logger = LoggerFactory.getLogger(ShippingController.class);

    private final UserService userService;
    private final OrderService orderService;
    private final ShippingMapper shippingMapper;

    public ShippingController(UserService userService, OrderService orderService, ShippingMapper shippingMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.shippingMapper = shippingMapper;
    }

    @GetMapping()//produces = "application/json"
    @ResponseStatus(HttpStatus.OK)
    public ShippingDTO shippingOrdersToday(@RequestHeader("Authorization") UUID adminId){
        if (!userService.isUserInRoleAdmin(adminId)) {
            logger.warn("Someone tried see the sipping orders but did not have admin id; id used : " + adminId);
            throw new Unauthorized("You are not authorized to see this list.");
        }
        return shippingMapper.mapOrderedItemsToDayToReport(orderService.getShippingOrdersOfToday());
    }
}
