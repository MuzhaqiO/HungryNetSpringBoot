package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.MenuDTO;
import com.hungerNet.Hunger.Net.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("getAll")
    public ResponseEntity<List<MenuDTO>> findAllMenus() {
        return ResponseEntity.ok(menuService.getMenus());
    }
    @GetMapping("menuId/{menuId}")
    public ResponseEntity<MenuDTO> getMenuById(@PathVariable UUID menuId) {
        return ResponseEntity.ok(menuService.getMenuById(menuId));
    }
    @PostMapping("addNewMenu")
    public ResponseEntity<MenuDTO> createMenu(@RequestBody MenuDTO menuDTO){
        return ResponseEntity.ok(menuService.addNewMenu(menuDTO));
    }
    @PutMapping("updateMenu")
    public ResponseEntity<MenuDTO> updateMenu(@RequestBody MenuDTO menuDTO) {
        return ResponseEntity.ok(menuService.updateMenu(menuDTO));
    }
    @DeleteMapping("delete/{menuId}")
    public void deleteMenu(@PathVariable UUID menuId) {
        menuService.deleteMenu(menuId);
    }
}
