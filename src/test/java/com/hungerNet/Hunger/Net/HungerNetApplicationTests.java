package com.hungerNet.Hunger.Net;

import com.hungerNet.Hunger.Net.model.Restaurant;
import com.hungerNet.Hunger.Net.repository.RestaurantRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HungerNetApplicationTests {

	@Autowired
	RestaurantRepo restaurantRepo;

	@Test
	@Order(1)
	public void testCreate(){
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantName("Bebe");
		restaurant.setLocation("Tirane");
		restaurantRepo.save(restaurant);
		assertNotNull(restaurantRepo.getByRestaurantName("Bebe"));
	}

	@Test
	@Order(2)
	public void testGetOne(){
		Restaurant restaurant = restaurantRepo.getByRestaurantName("Bebe");
		assertEquals("Tirane", restaurant.getLocation());
	}

	@Test
	@Order(3)
	public void testUpdate(){
		Restaurant restaurant = restaurantRepo.getByRestaurantName("Bebe");
		restaurant.setLocation("Durres");
		restaurantRepo.save(restaurant);
		assertNotEquals("Tirane", restaurantRepo.getByRestaurantName("Bebe").getLocation());
	}
}
