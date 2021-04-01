package com.example.domain.repository;

import com.example.domain.models.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {
    private static final Logger logger = LoggerFactory.getLogger(ItemRepository.class);
    private final List<Item> itemList;

    public ItemRepository() {
        this.itemList = new ArrayList<>();
        innit();
    }

    private void innit() {
        itemList.add(new Item(UUID.fromString("0852a3b6-0a61-4487-9a2a-f47f0a1af0f8"), "item99", "item99", 14.99, 5));
        itemList.add(new Item(UUID.fromString("5130a4d2-996b-4fa9-bb53-bb0ae2543d53"), "item98", "item98", 29.99, 0));
        itemList.add(new Item(UUID.fromString("b1a7946d-8371-4cbf-97f4-e8c525aa819c"), "item97", "item97", 8.99, 25));
        itemList.add(new Item(UUID.fromString("b4e7f7e4-d57d-4813-9da6-0a3fb938405d"), "item96", "item96", 24.99, 51));
    }

    public Collection<Item> getAllItems() {
        return Collections.unmodifiableCollection(itemList);
    }

    public Item addItem(Item item) {
        itemList.add(item);
        logger.info("Item was added to the database with id :" + item.getId());
        return item;
    }

    public Item UpDateItem(Item item) {
        Item itemToUpdate = itemList.stream().filter(c -> c.getName().equals(item.getName())).findFirst().orElse(null);
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setAmount(item.getAmount());
        itemToUpdate.setPrice(item.getPrice());
        return itemToUpdate;
    }
}
