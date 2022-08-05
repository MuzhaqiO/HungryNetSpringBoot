package com.hungerNet.Hunger.Net.dto.itemDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemDTO {
    private UUID menuId;
    private UUID itemId;
    private String itemName;
    private Double price;
}
