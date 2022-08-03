package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.MenuDTO;
import com.hungerNet.Hunger.Net.mapper.MenuMapper;
import com.hungerNet.Hunger.Net.model.Menu;
import com.hungerNet.Hunger.Net.repository.MenuRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepo menuRepo;
    private final MenuMapper menuMapper;

    public MenuDTO getMenuById(UUID menuId) {
        return menuMapper.toDTO(menuRepo.getReferenceById(menuId));
    }
    public List<MenuDTO> getMenus() {
        return menuMapper.toDTOs(menuRepo.findAll());
    }
    public MenuDTO addNewMenu(MenuDTO menuDTO){
        Menu createdMenu = menuRepo.save(menuMapper.toModel(menuDTO));
        return menuMapper.toDTO(createdMenu);
    }
    public MenuDTO updateMenu(MenuDTO menuDTO) {
        Menu menu = menuMapper.toModel(menuDTO);
        menuRepo.save(menu);
        return menuMapper.toDTO(menu);
    }
    public void deleteMenu(UUID menuId) {
        menuRepo.deleteById(menuId);
    }
}
