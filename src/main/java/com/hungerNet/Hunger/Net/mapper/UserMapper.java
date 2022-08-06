package com.hungerNet.Hunger.Net.mapper;

import com.hungerNet.Hunger.Net.dto.userDTO.RegisterUserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserDTO;
import com.hungerNet.Hunger.Net.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "restaurant.restaurantId", target = "restaurantId")
    UserDTO toDTO(User users);

    List<UserDTO> toDTOs(List<User> users);

    @Mapping(source = "restaurantId", target = "restaurant.restaurantId")
    User toModel(UserDTO usersDTO);

    List<User> ToModels(List<UserDTO> userDTOs);


    //REGISTER USER CLIENT MAPPER

    RegisterUserDTO toDTOClient(User users);

    List<RegisterUserDTO> toDTOsClient(List<User> users);


    User toModelClient(RegisterUserDTO registerUserDTO);

    List<User> ToModelsClient(List<RegisterUserDTO> registerUserDTOs);
}
