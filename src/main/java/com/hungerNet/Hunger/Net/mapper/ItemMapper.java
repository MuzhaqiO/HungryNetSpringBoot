package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.itemDTO.ItemDTO;
import com.hungerNet.Hunger.Net.dto.itemDTO.MenuItemDTO;
import com.hungerNet.Hunger.Net.dto.itemDTO.UpdateItemDTO;
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

    UpdateItemDTO toDTOUpdate (Item item);
    List<UpdateItemDTO> toDTOsUpdate (List<Item> items);
    Item toModelUpdate (UpdateItemDTO updateItemDTO);
    List<Item> toModelsUpdate (List<UpdateItemDTO> updateItemDTOs);

    MenuItemDTO toDTOMenu (Item item);
    List<MenuItemDTO> toDTOsMenu (List<Item> items);
    Item toModelMenu (MenuItemDTO menuItemDTO);
    List<Item> toModelsMenu (List<MenuItemDTO> menuItemDTOs);

}
