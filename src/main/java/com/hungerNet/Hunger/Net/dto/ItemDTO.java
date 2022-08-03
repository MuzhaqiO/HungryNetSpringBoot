package com.hungerNet.Hunger.Net.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemDTO {
    private UUID itemId;
    private String itemName;
    private Double price;
}
