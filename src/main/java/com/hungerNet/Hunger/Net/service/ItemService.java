package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.itemDTO.ItemDTO;
import com.hungerNet.Hunger.Net.dto.menuDTO.MenuDTO;
import com.hungerNet.Hunger.Net.mapper.ItemMapper;
import com.hungerNet.Hunger.Net.model.Item;
import com.hungerNet.Hunger.Net.model.Menu;
import com.hungerNet.Hunger.Net.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;
    private final ItemMapper itemMapper;

    private final MenuService menuService;

    public ItemDTO getItemById(UUID itemId) {
        return itemMapper.toDTO(itemRepo.getReferenceById(itemId));
    }
    public List<ItemDTO> getItems() {
        return itemMapper.toDTOs(itemRepo.findAll());
    }

    public List<ItemDTO> getItemsByActiveMenu(UUID menuId) {
        MenuDTO menu = menuService.getMenuById(menuId);
        if (menu.getMenuStatus() != null && menu.getMenuStatus().equals(Boolean.TRUE)) {
            return itemMapper.toDTOs(itemRepo.getItemsByMenusMenuId(menuId));
        }
        return new ArrayList<>();
    }

    public ItemDTO addNewItem(ItemDTO itemDTO){
        Item createdItem = itemRepo.save(itemMapper.toModel(itemDTO));
        return itemMapper.toDTO(createdItem);
    }
    public ItemDTO updateItem(ItemDTO itemDTO) {
        Item item = itemMapper.toModel(itemDTO);
        itemRepo.save(item);
        return itemMapper.toDTO(item);
    }
    public void deleteItem(UUID itemId) {
        itemRepo.deleteById(itemId);
    }

    public List<ItemDTO> getItemsByMenu(UUID menuId) {
        return itemMapper.toDTOs(itemRepo.getItemsByMenusMenuId(menuId));
    }
}
