package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.menuDTO.MenuDTO;
import com.hungerNet.Hunger.Net.dto.restaurantDTO.RestaurantDTO;
import com.hungerNet.Hunger.Net.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("getAll")
    public ResponseEntity<List<RestaurantDTO>> findAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getRestaurants());
    }
    @GetMapping("restaurantId/{restaurantId}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable UUID restaurantId) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(restaurantId));
    }
    @GetMapping("restaurantName/{restaurantName}")
    public ResponseEntity<RestaurantDTO> getRestaurantByName(@PathVariable String restaurantName) {
        return ResponseEntity.ok(restaurantService.getByRestaurantName(restaurantName));
    }
    @PostMapping("addNewRestaurant")
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        return ResponseEntity.ok(restaurantService.addNewRestaurant(restaurantDTO));
    }
    @PutMapping("updateRestaurant")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(restaurantDTO));
    }
    @DeleteMapping("delete/{restaurantId}")
    public void deleteRestaurant(@PathVariable UUID restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }
}
