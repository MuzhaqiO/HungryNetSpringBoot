package com.hungerNet.Hunger.Net.dto.userDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterUserDTO {
    private UUID userId;
    private String username;
    private String password;
}
