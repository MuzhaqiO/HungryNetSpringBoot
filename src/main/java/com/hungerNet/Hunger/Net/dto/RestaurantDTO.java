package com.hungerNet.Hunger.Net.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RestaurantDTO {
    private UUID restaurantId;
    private String restaurantName;
    private String location;
}
