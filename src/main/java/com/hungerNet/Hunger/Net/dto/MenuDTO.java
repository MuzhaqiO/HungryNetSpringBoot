package com.hungerNet.Hunger.Net.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuDTO {
    private UUID menuId;
    private String menuName;
    private Boolean menuStatus;
}
