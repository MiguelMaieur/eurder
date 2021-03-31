package com.example.service;

import com.example.domain.models.item.Item;
import com.example.domain.repository.ItemRepository;
import com.example.infrastructure.exceptions.ItemAlreadyExitsException;
import com.example.infrastructure.exceptions.ItemDontExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item) {
        if (!checkIfItemIsDuplicate(item)) {
            logger.warn("A admin tried to register a item that is already in the database : " + item.getName());
            throw new ItemAlreadyExitsException("There is a item with the same name");
        }
        return itemRepository.addItem(item);
    }

    private boolean checkIfItemIsDuplicate(Item item) {
        return itemRepository.getAllItems().stream().filter(c -> c.getName().toLowerCase().equals(item.getName())).collect(Collectors.toList()).isEmpty();
    }

    public Collection<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    public Item getItemById(UUID id) {
        return itemRepository.getAllItems().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Item UpdateItem(Item item){
        if (checkIfItemIsDuplicate(item)) {
            logger.warn("A admin tried to update a item that is not in the database : " + item.getName());
            throw new ItemDontExists("There is no item with the name " + item.getName());
        }
        return itemRepository.UpDateItem(item);
    }
}
