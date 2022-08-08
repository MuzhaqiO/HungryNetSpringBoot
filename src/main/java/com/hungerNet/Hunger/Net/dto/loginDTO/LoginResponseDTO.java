package com.hungerNet.Hunger.Net.dto.loginDTO;

import com.hungerNet.Hunger.Net.dto.userDTO.UserEntityResponseDTO;
import lombok.Data;

@Data
public class LoginResponseDTO {

    private String accessToken;
    private String tokenType;
    private UserEntityResponseDTO user;
    private String role2;
}
