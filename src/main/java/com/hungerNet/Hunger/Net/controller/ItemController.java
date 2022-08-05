package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.itemDTO.ItemDTO;
import com.hungerNet.Hunger.Net.dto.menuDTO.MenuDTO;
import com.hungerNet.Hunger.Net.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("getAll")
    public ResponseEntity<List<ItemDTO>> findAllItems() {
        return ResponseEntity.ok(itemService.getItems());
    }
    @GetMapping("getByActiveMenu/{menuId}")
    public ResponseEntity<List<ItemDTO>> getByActiveMenu(@PathVariable UUID menuId) {
        return ResponseEntity.ok(itemService.getItemsByActiveMenu(menuId));
    }
    @GetMapping("itemId/{itemId}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable UUID itemId) {
        return ResponseEntity.ok(itemService.getItemById(itemId));
    }
    @PostMapping("addNewItem")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.ok(itemService.addNewItem(itemDTO));
    }
    @PutMapping("updateItem")
    public ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(itemService.updateItem(itemDTO));
    }
    @DeleteMapping("delete/{itemId}")
    public void deleteItem(@PathVariable UUID itemId) {
        itemService.deleteItem(itemId);
    }
    @GetMapping("getItemsByMenu/{menuId}")
    public ResponseEntity<List<ItemDTO>> getItemsByMenu(@PathVariable UUID menuId) {
        return ResponseEntity.ok(itemService.getItemsByMenu(menuId));
    }
}
