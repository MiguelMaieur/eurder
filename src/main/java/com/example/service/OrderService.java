package com.example.service;

import com.example.api.dto.order.OrderItemDTO;
import com.example.domain.models.item.Item;
import com.example.domain.models.order.OrderedItem;
import com.example.domain.repository.OrderRepository;
import com.example.infrastructure.exceptions.OrderMissingField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;
    private final ItemService itemService;


    public OrderService(OrderRepository orderRepository, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }

    public UUID saveOrders(Collection<OrderItemDTO> orderList, UUID userid) {
        CheckInput(orderList, userid);

        UUID groupId = UUID.randomUUID();
        for (var orderedItem : orderList) {
            orderRepository.addOrder(makeOrderedItem(userid, groupId, orderedItem, itemService.getItemById(orderedItem.getId())));
        }
        return groupId;
    }

    public Collection<OrderedItem> getOrdersByGroupId(UUID id) {
        return orderRepository.getAllOrders().stream().filter(c -> c.getGroupId().equals(id)).collect(Collectors.toList());
    }

    private void CheckInput(Collection<OrderItemDTO> orderList, UUID userid) {
        if (!areItemsOk(orderList)) {
            logger.warn("A user did try to order a item and not all fields where filled in userid: " + userid);
            throw new OrderMissingField("There was a field missing in your order.");
        }

        if (!areItemsKnow(orderList)) {
            logger.warn("A user did try to order a item that was not in the database. userid: " + userid);
            throw new OrderMissingField("There was a item id that is not known.");
        }
    }

    private boolean areItemsKnow(Collection<OrderItemDTO> orderList) {
        for (var item : orderList) {
            if (itemService.getAllItems().stream().filter(c -> c.getId().equals(item.getId())).findFirst().isEmpty())
                return false;
        }
        return true;
    }

    private OrderedItem makeOrderedItem(UUID userid, UUID groupId, OrderItemDTO order, Item item) {
        return new OrderedItem(UUID.randomUUID(), groupId, userid, order.getId(), order.getAmount()
                , item.getAmount() >= 1 ? LocalDate.now().plusDays(1) : LocalDate.now().plusDays(7)
                , order.getAmount() * item.getPrice(), LocalDate.now());
    }

    private boolean areItemsOk(Collection<OrderItemDTO> orderList) {
        return orderList.stream().filter(c -> c.getId() == null || c.getAmount() < 1).count() == 0;
    }

    public Map<UUID, List<OrderedItem>> getOrderHistory(UUID userId) {
        return orderRepository.getAllOrders().stream().filter(c -> c.getMemberId().equals(userId)).collect(groupingBy(OrderedItem::getGroupId));
    }

    public UUID reOrder(UUID groupId, UUID userId) {
        if (!isReOrderIdOk(groupId, userId)) {
            logger.warn("A user did try to reorder a order that was not in the database. groupid: " + groupId);
            throw new OrderMissingField("There was nothing found to reorder, pls try again.");
        }
        var oldOrder = getOrdersByGroupId(groupId);
        var oldOrderMaped = oldOrder.stream().map(c -> new OrderItemDTO().setId(c.getItemId()).setAmount(c.getAmount()).setShippingdate(c.getShippingDate())).collect(Collectors.toList());
        return saveOrders(oldOrderMaped, userId);
    }

    private boolean isReOrderIdOk(UUID groupId, UUID userId) {
        return orderRepository.getAllOrders().stream().filter(c -> c.getGroupId().equals(groupId) && c.getMemberId().equals(userId)).count() > 0;
    }
}
