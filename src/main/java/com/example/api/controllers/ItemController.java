package com.example.api.controllers;

import com.example.api.dto.item.CreateItemDTO;
import com.example.api.dto.item.ItemDTO;
import com.example.api.dto.item.UpdateItemDTO;
import com.example.api.mappers.ItemMapper;
import com.example.infrastructure.exceptions.Unauthorized;
import com.example.service.ItemService;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    private final ItemService itemService;
    private final UserService userService;
    private final ItemMapper itemMapper;

    public ItemController(ItemService itemService, UserService userService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.userService = userService;
        this.itemMapper = itemMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addItem(@RequestBody CreateItemDTO createUserDTO, @RequestHeader("Authorization") UUID adminId) {
        if (!userService.isUserInRoleAdmin(adminId)) {
            logger.warn("Someone tried to register an item but did not have admin id; id used : " + adminId);
            throw new Unauthorized("You are not authorized to add a item.");
        }
        return itemMapper.itemToItemDTO(itemService.addItem(itemMapper.CreateItemDTOToItem(createUserDTO)));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Collection<ItemDTO> getAllItems() {
        return itemMapper.itemListToItemDTOList(itemService.getAllItems());
    }

    @PatchMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ItemDTO updateItem(@RequestBody UpdateItemDTO updateItemDTO, @RequestHeader("Authorization") UUID adminId) {
        if (!userService.isUserInRoleAdmin(adminId)) {
            logger.warn("Someone tried to update an item but did not have a admin id; id used : " + adminId);
            throw new Unauthorized("You are not authorized to update a item.");
        }
        return itemMapper.itemToItemDTO(itemService.UpdateItem(itemMapper.updateItemDTOToItem(updateItemDTO)));
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Collection<ItemDTO> itemOverview(@RequestParam Optional<String> indicator, @RequestHeader("Authorization") UUID adminId) {
        if (!userService.isUserInRoleAdmin(adminId)) {
            logger.warn("Someone tried to see the item overview but did not have admin id; id used : " + adminId);
            throw new Unauthorized("You are not authorized see this list.");
        }
        return itemMapper.itemListToItemDTOList(itemService.getItemsByUrgency(indicator.orElseGet(() -> "")));
    }
}
