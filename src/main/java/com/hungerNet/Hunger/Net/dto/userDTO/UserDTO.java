package com.hungerNet.Hunger.Net.dto.userDTO;

import com.hungerNet.Hunger.Net.enums.Roles;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Data
public class UserDTO {
    private UUID userId;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;
    private UUID restaurantId;
}
