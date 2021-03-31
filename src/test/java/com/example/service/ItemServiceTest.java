package com.example.service;

import com.example.domain.models.item.Item;
import com.example.domain.repository.ItemRepository;
import com.example.infrastructure.exceptions.ItemAlreadyExitsException;
import com.example.infrastructure.exceptions.OrderMissingField;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    @Test
    void getAllItemsGivesMeOne() {
        //given
        ItemService itemService = new ItemService(new ItemRepository());
        //when
        int size = itemService.getAllItems().size();
        //then
        assertEquals(1,size);
    }

    @Test
    void getItemByIdGivesOneItem() {
        //given
        ItemService itemService = new ItemService(new ItemRepository());
        //when
        var item = itemService.getItemById(UUID.fromString("0852a3b6-0a61-4487-9a2a-f47f0a1af0f8"));
        //then
        assertEquals(UUID.fromString("0852a3b6-0a61-4487-9a2a-f47f0a1af0f8"),item.getId());
    }

    @Test
    void addItemAgainThrowsError() {
        //given
        ItemService itemService = new ItemService(new ItemRepository());
        //when
        Exception exception = assertThrows(ItemAlreadyExitsException.class,() ->itemService.addItem(new Item(UUID.fromString("0852a3b6-0a61-4487-9a2a-f47f0a1af0f8"),"item99","item",15.5,5)));
        //then
        assertEquals("There is a item with the same name",exception.getMessage());
    }
}