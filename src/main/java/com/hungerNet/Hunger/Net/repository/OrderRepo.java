package com.hungerNet.Hunger.Net.repository;

import com.hungerNet.Hunger.Net.model.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepo extends JpaRepository<Order, UUID> {
    List<Order> findAllByOrderByOrderDate();

    @Query("SELECT o FROM Order o WHERE " + "o.orderStatus = com.hungerNet.Hunger.Net.enums.OrderStatus.CREATED")
    List<Order> getCreatedOrders();
    @Query("SELECT o FROM Order o WHERE " + "o.orderStatus = com.hungerNet.Hunger.Net.enums.OrderStatus.APPROVED")
    List<Order> getApprovedOrders();
    @Query("SELECT o FROM Order o WHERE " + "o.orderStatus = com.hungerNet.Hunger.Net.enums.OrderStatus.REJECTED")
    List<Order> getRejectedOrders();
    @Query("SELECT o FROM Order o WHERE " + "o.orderStatus = com.hungerNet.Hunger.Net.enums.OrderStatus.PREPARED")
    List<Order> getPreparedOrders();
    @Query("SELECT o FROM Order o WHERE " + "o.orderStatus = com.hungerNet.Hunger.Net.enums.OrderStatus.WAITING_FOR_DELIVERY")
    List<Order> getWaitingOrders();
    @Query("SELECT o FROM Order o WHERE " + "o.orderStatus = com.hungerNet.Hunger.Net.enums.OrderStatus.DELIVERED")
    List<Order> getDeliveredOrders();

    @Query("SELECT o FROM Order o WHERE o.users.userId = ?1 ORDER BY o.orderDate ASC" )
    List<Order> getOrdersByUser(UUID userId);
    @Query("SELECT o FROM Order o WHERE o.restaurants.restaurantId = ?1 ORDER BY o.orderDate ASC" )
    List<Order> getOrdersByRestaurant(UUID restaurantId);
}
