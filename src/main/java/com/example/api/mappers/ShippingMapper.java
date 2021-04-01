package com.example.api.mappers;

import com.example.api.dto.order.DeliveryAddress;
import com.example.api.dto.shipping.ShippingDTO;
import com.example.api.dto.shipping.ShippingToDayOrder;
import com.example.domain.models.order.OrderedItem;
import com.example.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class ShippingMapper {

    private final UserService userService;

    public ShippingMapper(UserService userService) {
        this.userService = userService;
    }

    public ShippingDTO mapOrderedItemsToDayToReport(Map<UUID, List<OrderedItem>> list){
        var result = new ShippingDTO();
        for (var order : list.entrySet()){
            var user = userService.getUserById(order.getValue().stream().findFirst().orElse(null).getMemberId());

            result.addShippingOrderToday(new ShippingToDayOrder().setRow(order)
                    .setDeliveryAddress(new DeliveryAddress(user.getUserInfo().getFirstName() + " " + user.getUserInfo().getLastName(),user.getAddress().getStreet() + user.getAddress().getStreetNumber(),user.getAddress().getPostalCode(),user.getAddress().getCity())));
        }
        return result;
    }
}
