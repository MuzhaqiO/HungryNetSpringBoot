package com.hungerNet.Hunger.Net.dto.userDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {
    private UUID userId;
    private String username;
    private String password;
    private UUID restaurantId;
}
