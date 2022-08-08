package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.itemDTO.ItemDTO;
import com.hungerNet.Hunger.Net.dto.itemDTO.UpdateItemDTO;
import com.hungerNet.Hunger.Net.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PreAuthorize("hasRole('RESTAURANT_MANAGER') or hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("getByActiveMenu/{menuId}")
    public ResponseEntity<List<ItemDTO>> getByActiveMenu(@PathVariable UUID menuId) {
        return ResponseEntity.ok(itemService.getItemsByActiveMenu(menuId));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER') or hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("getByOrder/{orderId}")
    public ResponseEntity<List<ItemDTO>> getByOrder(@PathVariable UUID orderId) {
        return ResponseEntity.ok(itemService.getItemByOrderId(orderId));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER') or hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("itemId/{itemId}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable UUID itemId) {
        return ResponseEntity.ok(itemService.getItemById(itemId));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @PostMapping("addNewItem")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.ok(itemService.addNewItem(itemDTO));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @PutMapping("updateItem")
    public ResponseEntity<ItemDTO> updateItem(@RequestBody UpdateItemDTO updateItemDTO) {
        return ResponseEntity.ok(itemService.updateItem(updateItemDTO));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @DeleteMapping("delete/{itemId}")
    public void deleteItem(@PathVariable UUID itemId) {
        itemService.deleteItem(itemId);
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER') or hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("getItemsByMenu/{menuId}")
    public ResponseEntity<List<ItemDTO>> getItemsByMenu(@PathVariable UUID menuId) {
        return ResponseEntity.ok(itemService.getItemsByMenu(menuId));
    }
}
