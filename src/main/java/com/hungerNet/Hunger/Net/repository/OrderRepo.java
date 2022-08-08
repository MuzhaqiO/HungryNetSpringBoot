package com.hungerNet.Hunger.Net.repository;

import com.hungerNet.Hunger.Net.enums.OrderStatus;
import com.hungerNet.Hunger.Net.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepo extends JpaRepository<Order, UUID> {

    @Query("SELECT o FROM Order o WHERE " + "o.orderStatus = ?1")
    List<Order> getCreatedOrderStatus(OrderStatus orderStatus);
    @Query("SELECT o FROM Order o WHERE o.users.userId = ?1 ORDER BY o.orderDate ASC" )
    List<Order> getOrdersByUser(UUID userId);
    @Query("SELECT o FROM Order o WHERE o.restaurants.restaurantId = ?1 ORDER BY o.orderDate ASC" )
    List<Order> getOrdersByRestaurant(UUID restaurantId);
}
