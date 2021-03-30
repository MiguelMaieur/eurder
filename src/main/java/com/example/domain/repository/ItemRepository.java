package com.example.domain.repository;

import com.example.domain.models.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class ItemRepository {
    private static final Logger logger = LoggerFactory.getLogger(ItemRepository.class);
    private final List<Item> itemList;

    public ItemRepository() {
        this.itemList = new ArrayList<>();
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
