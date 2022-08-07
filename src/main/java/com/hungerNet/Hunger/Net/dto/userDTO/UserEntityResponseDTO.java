package com.hungerNet.Hunger.Net.dto.userDTO;

import com.hungerNet.Hunger.Net.dto.RoleDTO;
import com.hungerNet.Hunger.Net.enums.RoleName2;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.UUID;

@Data
public class UserEntityResponseDTO {
    private UUID userId;
    private String username;
    private UUID restaurantId;
    @Enumerated(EnumType.STRING)
    private RoleName2 role2;
}
