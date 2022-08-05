package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.restaurantDTO.RestaurantDTO;
import com.hungerNet.Hunger.Net.mapper.RestaurantMapper;
import com.hungerNet.Hunger.Net.model.Restaurant;
import com.hungerNet.Hunger.Net.repository.RestaurantRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepo restaurantRepo;
    private final RestaurantMapper restaurantMapper;

    public RestaurantDTO getRestaurantById(UUID restaurantId) {
        return restaurantMapper.toDTO(restaurantRepo.getReferenceById(restaurantId));
    }
    public List<RestaurantDTO> getRestaurants() {
        return restaurantMapper.toDTOs(restaurantRepo.findAll());
    }
    public RestaurantDTO addNewRestaurant(RestaurantDTO restaurantDTO){
        Restaurant createdRestaurant = restaurantRepo.save(restaurantMapper.toModel(restaurantDTO));
        return restaurantMapper.toDTO(createdRestaurant);
    }
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantMapper.toModel(restaurantDTO);
        restaurantRepo.save(restaurant);
        return restaurantMapper.toDTO(restaurant);
    }
    public void deleteRestaurant(UUID restaurantId) {
        restaurantRepo.deleteById(restaurantId);
    }
}
