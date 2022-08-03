package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.ItemDTO;
import com.hungerNet.Hunger.Net.model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDTO toDTO (Item item);
    List<ItemDTO> toDTOs (List<Item> items);
    Item toModel (ItemDTO itemDTO);
    List<Item> toModels (List<ItemDTO> itemDTOs);

}
