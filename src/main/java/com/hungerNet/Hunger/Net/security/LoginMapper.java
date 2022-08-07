package com.hungerNet.Hunger.Net.security;

import com.hungerNet.Hunger.Net.dto.RoleDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserEntityResponseDTO;
import com.hungerNet.Hunger.Net.model.Role;
import com.hungerNet.Hunger.Net.model.User;
import com.sun.istack.Nullable;

import java.util.List;

public class LoginMapper {
//    public static UserEntityResponseDTO entityToDtoMapper(User user) {
//        UserEntityResponseDTO responseDTO = new UserEntityResponseDTO();
//        responseDTO.setUserId(user.getUserId());
//        responseDTO.setUsername(user.getUsername());
//        responseDTO.setRestaurantId(user.getRestaurant().getRestaurantId());
//        List<RoleDTO> roleResponse = user.getRoles().stream().map(role -> {
//            RoleDTO roleResponseDTO = new RoleDTO();
//            roleResponseDTO.setRoleId(role.getRoleId());
//            roleResponseDTO.setName(role.getName());
//            return roleResponseDTO;
//        }).toList();
//        responseDTO.setRoles(roleResponse);
//        return responseDTO;
//    }
//
//        public static User dtoToEntityMapper(UserDTO dto, @Nullable User user, @Nullable List<Role> roles) {
//        if (user == null) {
//            user = new User();
//        }
//
//        user.setUsername(dto.getUsername());
//        user.setPassword(dto.getPassword());
//        user.setRoles(roles);
//        return user;
//    }
//
//    public static List<RoleDTO> userRolesMapper(List<Role> roles) {
//        return roles.stream().map(role -> {
//            RoleDTO roleResponse = new RoleDTO();
//            roleResponse.setRoleId(role.getRoleId());
//            roleResponse.setName(role.getName());
//            return roleResponse;
//        }).toList();
//    }
}
