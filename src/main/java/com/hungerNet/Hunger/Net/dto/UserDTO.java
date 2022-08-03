package com.hungerNet.Hunger.Net.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {
    private UUID userId;
    private String username;
    private String password;
}
