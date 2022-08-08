package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.menuDTO.MenuDTO;
import com.hungerNet.Hunger.Net.dto.menuDTO.MenuRequestDTO;
import com.hungerNet.Hunger.Net.model.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    @Mapping(source = "restaurants.restaurantId", target = "restaurantId")
    MenuDTO toDTO (Menu menu);
    List<MenuDTO> toDTOs (List<Menu> menus);
    @Mapping(source = "restaurantId", target = "restaurants.restaurantId")
    Menu toModel (MenuDTO menuDTO);
    List<Menu> toModels (List<MenuDTO> menuDTOs);

    @Mapping(source = "restaurants.restaurantId", target = "restaurantId")
    MenuRequestDTO toDTORequest (Menu menu);
    List<MenuRequestDTO> toDTOsRequest (List<Menu> menus);
    @Mapping(source = "restaurantId", target = "restaurants.restaurantId")
    Menu toModelRequest (MenuRequestDTO menuRequestDTO);
    List<Menu> toModelsRequest (List<MenuRequestDTO> menuRequestDTOs);
}
