package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.MenuDTO;
import com.hungerNet.Hunger.Net.model.Menu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    MenuDTO toDTO (Menu menu);
    List<MenuDTO> toDTOs (List<Menu> menus);
    Menu toModel (MenuDTO menuDTO);
    List<Menu> toModels (List<MenuDTO> menuDTOs);
}
