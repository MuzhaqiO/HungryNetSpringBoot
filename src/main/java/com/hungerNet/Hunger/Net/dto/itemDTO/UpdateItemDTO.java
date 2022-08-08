package com.hungerNet.Hunger.Net.dto.itemDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateItemDTO {
    private UUID itemId;
    private String itemName;
    private Double price;
}
