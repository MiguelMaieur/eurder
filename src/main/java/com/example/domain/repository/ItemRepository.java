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
        itemList.add(new Item(UUID.fromString("0852a3b6-0a61-4487-9a2a-f47f0a1af0f8"),"item99","item",15.5,5));
    }

    public Collection<Item> getAllItems(){
        return Collections.unmodifiableCollection(itemList);
    }

    public Item addItem(Item item){
        itemList.add(item);
        logger.info("Item was added to the database with id :" + item.getId());
        return item;
    }
}
