package com.hungerNet.Hunger.Net.dto.userDTO;

import com.hungerNet.Hunger.Net.dto.RoleDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserEntityResponseDTO {
    private UUID userId;
    private String username;
    private List<RoleDTO> roles;
}
