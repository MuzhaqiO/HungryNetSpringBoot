package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.RestaurantDTO;
import com.hungerNet.Hunger.Net.model.Restaurant;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDTO toDTO (Restaurant restaurant);
    List<RestaurantDTO> toDTOs (List<Restaurant> restaurants);
    Restaurant toModel (RestaurantDTO restaurantDTO);
    List<Restaurant> toModels (List<RestaurantDTO> restaurantDTOs);
}
