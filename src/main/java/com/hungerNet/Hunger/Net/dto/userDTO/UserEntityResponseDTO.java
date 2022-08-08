package com.hungerNet.Hunger.Net.dto.userDTO;

import com.hungerNet.Hunger.Net.enums.RoleName;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Data
public class UserEntityResponseDTO {
    private UUID userId;
    private String username;
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
    private UUID restaurantId;

}
