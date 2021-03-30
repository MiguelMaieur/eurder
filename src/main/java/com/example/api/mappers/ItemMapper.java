package com.example.api.mappers;

import com.example.api.dto.item.CreateItemDTO;
import com.example.api.dto.item.ItemDTO;
import com.example.domain.models.item.Item;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    public Item CreateItemDTOToItem(CreateItemDTO createItemDTO) {
        return new Item(createItemDTO.getName(), createItemDTO.getDescription(), createItemDTO.getPrice(), createItemDTO.getAmount());
    }

    public ItemDTO itemToItemDTO(Item item){
        return new ItemDTO().setId(item.getId())
                .setAmount(item.getAmount())
                .setDescription(item.getDescription())
                .setName(item.getName())
                .setPrice(item.getPrice());
    }

    public Collection<ItemDTO> itemListToItemDTOList(Collection<Item> items){
        return items.stream().map(c -> new ItemDTO().setId(c.getId())
                .setAmount(c.getAmount())
                .setDescription(c.getDescription())
                .setName(c.getName())
                .setPrice(c.getPrice())).collect(Collectors.toList());
    }
}
