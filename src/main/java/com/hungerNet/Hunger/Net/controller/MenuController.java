package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.menuDTO.MenuDTO;
import com.hungerNet.Hunger.Net.dto.menuDTO.MenuListDTO;
import com.hungerNet.Hunger.Net.dto.menuDTO.MenuRequestDTO;
import com.hungerNet.Hunger.Net.service.MenuService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PreAuthorize("hasRole('RESTAURANT_MANAGER') or hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("menuId/{menuId}")
    public ResponseEntity<MenuDTO> getMenuById(@PathVariable UUID menuId) {
        return ResponseEntity.ok(menuService.getMenuById(menuId));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @PostMapping("addNewMenu")
    public ResponseEntity<MenuDTO> createMenu(@RequestBody MenuDTO menuDTO){
        return ResponseEntity.ok(menuService.addNewMenu(menuDTO));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @PutMapping("updateMenu")
    public ResponseEntity<MenuDTO> updateMenu(@RequestBody MenuRequestDTO menuDTO) {
        return ResponseEntity.ok(menuService.updateMenu(menuDTO));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @DeleteMapping("delete/{menuId}")
    public void deleteMenu(@PathVariable UUID menuId) {
        menuService.deleteMenu(menuId);
    }
    @PreAuthorize("hasRole('CLIENT')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("getMenusByRestaurant/{restaurantId}")
    public ResponseEntity<List<MenuDTO>> getMenusByRestaurant(@PathVariable UUID restaurantId) {
        return ResponseEntity.ok(menuService.getMenusByRestaurant(restaurantId));
    }
    @PreAuthorize("hasRole('RESTAURANT_MANAGER')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @PostMapping("getMenusByRestaurantAndUser")
    public ResponseEntity<List<MenuDTO>> getMenusByRestaurantAndUser(@RequestBody MenuListDTO menuListDTO) {
        return ResponseEntity.ok(menuService.getMenusByRestaurantAndUser(menuListDTO));
    }
}
