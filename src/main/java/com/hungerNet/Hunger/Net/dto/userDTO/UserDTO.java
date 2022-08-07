package com.hungerNet.Hunger.Net.dto.userDTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDTO {
    private String username;
    private String password;
    private UUID restaurantId;
    private String role2;
}
