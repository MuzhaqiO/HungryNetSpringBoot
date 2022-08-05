package com.hungerNet.Hunger.Net.dto.menuDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuListDTO {
    private UUID restaurantId;
    private UUID userId;
}
