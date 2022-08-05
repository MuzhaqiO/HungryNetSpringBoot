package com.hungerNet.Hunger.Net.repository;

import com.hungerNet.Hunger.Net.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepo extends JpaRepository<Menu, UUID> {
    @Query("SELECT m FROM Menu m WHERE m.menuStatus=TRUE AND m.restaurants.restaurantId=?1")
    List<Menu> getMenuByRestaurantsRestaurantId(UUID restaurantId);

    @Query("SELECT m FROM Menu m " +
            "WHERE m.restaurants.restaurantId = ?1 " +
            "AND m.restaurants.user.userId = ?2")
    List<Menu> getMenusByRestaurantAndUser(UUID restaurantId, UUID userId);
}
