package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.itemDTO.ItemDTO;
import com.hungerNet.Hunger.Net.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    @Mapping(source = "menus.menuId", target = "menuId")
    ItemDTO toDTO (Item item);
    List<ItemDTO> toDTOs (List<Item> items);
    @Mapping(source = "menuId", target = "menus.menuId")
    Item toModel (ItemDTO itemDTO);
    List<Item> toModels (List<ItemDTO> itemDTOs);

}
