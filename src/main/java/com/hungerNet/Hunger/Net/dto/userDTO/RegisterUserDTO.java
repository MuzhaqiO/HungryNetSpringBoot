package com.hungerNet.Hunger.Net.dto.userDTO;

import com.hungerNet.Hunger.Net.enums.Roles;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Data
public class RegisterUserDTO {
    private UUID userId;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role = Roles.CLIENT;
}
