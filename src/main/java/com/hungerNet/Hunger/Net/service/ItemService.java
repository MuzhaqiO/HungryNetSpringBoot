package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.ItemDTO;
import com.hungerNet.Hunger.Net.mapper.ItemMapper;
import com.hungerNet.Hunger.Net.model.Item;
import com.hungerNet.Hunger.Net.model.User;
import com.hungerNet.Hunger.Net.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;
    private final ItemMapper itemMapper;

    public ItemDTO getItemById(UUID itemId) {
        return itemMapper.toDTO(itemRepo.getReferenceById(itemId));
    }
    public List<ItemDTO> getItems() {
        return itemMapper.toDTOs(itemRepo.findAll());
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
}
