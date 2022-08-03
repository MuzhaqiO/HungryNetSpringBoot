package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.UserDTO;
import com.hungerNet.Hunger.Net.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User users);

    List<UserDTO> toDTOs(List<User> users);

    User toModel(UserDTO usersDTO);

    List<User> ToModels(List<UserDTO> userDTOs);
}
