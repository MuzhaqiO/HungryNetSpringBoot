package com.hungerNet.Hunger.Net.security;

import com.hungerNet.Hunger.Net.dto.RoleDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserEntityResponseDTO;
import com.hungerNet.Hunger.Net.model.Role;
import com.hungerNet.Hunger.Net.model.User;

import java.util.List;

public class LoginMapper {
    public static UserEntityResponseDTO entityToDtoMapper(User user) {
        UserEntityResponseDTO responseDTO = new UserEntityResponseDTO();
        responseDTO.setUserId(user.getUserId());
        responseDTO.setUsername(user.getUsername());
        List<RoleDTO> roleResponse = user.getRoles().stream().map(role -> {
            RoleDTO roleResponseDTO = new RoleDTO();
            roleResponseDTO.setRoleId(role.getRoleId());
            roleResponseDTO.setRoleName(role.getRoleName());
            return roleResponseDTO;
        }).toList();
        responseDTO.setRoles(roleResponse);
        return responseDTO;
    }

    public static List<RoleDTO> userRolesMapper(List<Role> roles) {
        return roles.stream().map(role -> {
            RoleDTO roleResponse = new RoleDTO();
            roleResponse.setRoleId(role.getRoleId());
            roleResponse.setRoleName(role.getRoleName());
            return roleResponse;
        }).toList();
    }
}
