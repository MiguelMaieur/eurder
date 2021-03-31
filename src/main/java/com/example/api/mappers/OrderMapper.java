package com.example.api.mappers;

import com.example.api.dto.order.*;
import com.example.domain.models.order.OrderedItem;
import com.example.domain.models.user.User;
import com.example.service.OrderService;
import com.example.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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

        return new OrderedItemsDTO().setOrderId(groupId)
                .setdeliveryAddress(getAddress(userService.getUserById(userId)))
                .setItemList(getItemslist(orderList))
                .setTotalPrice(getTotalPrice(orderList));
    }

    public HistoryReportDTO mapToHistoryReportDTO(Map<UUID, List<OrderedItem>> orderHistory){
        var result = new HistoryReportDTO();
        for (var order : orderHistory.entrySet()){
            result.addHistory(new HistoryReport().setRow(order))//mappen naar new object met minder velden
            .setTotalOrdersPrice(order.getValue().stream().mapToDouble(OrderedItem::getTotalAmount).sum());
        }
        return result;
    }

    private Double getTotalPrice(Collection<OrderedItem> orderList) {
        return orderList.stream().mapToDouble(OrderedItem::getTotalAmount).sum();
    }

    private Collection<OrderItemDTO> getItemslist(Collection<OrderedItem> orderList) {
        return orderList.stream().map(c -> new OrderItemDTO().setId(c.getItemId()).setAmount(c.getAmount()).setShippingdate(c.getShippingDate())).collect(Collectors.toList());
    }

    private DeliveryAddress getAddress(User user){
        return new DeliveryAddress(user.getUserInfo().getFirstName() + " " + user.getUserInfo().getLastName()
                ,user.getAddress().getStreet() + " " + user.getAddress().getStreetNumber()
                ,user.getAddress().getPostalCode(),user.getAddress().getCity());
    }

    public ReOrderDTO uuidToReOrderDTO(UUID reorderId){
        return new ReOrderDTO().setOrderId(reorderId);
    }
}
