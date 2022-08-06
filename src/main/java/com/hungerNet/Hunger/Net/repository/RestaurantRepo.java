package com.hungerNet.Hunger.Net.repository;

import com.hungerNet.Hunger.Net.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, UUID> {
    Restaurant getByRestaurantName(String restaurantName);

}
