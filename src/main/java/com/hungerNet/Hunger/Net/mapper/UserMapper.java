package com.hungerNet.Hunger.Net.mapper;


import com.hungerNet.Hunger.Net.dto.userDTO.UserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserEntityResponseDTO;
import com.hungerNet.Hunger.Net.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "restaurant.restaurantId", target = "restaurantId")
    UserDTO toDTO(User user);
    List<UserDTO> toDTOs(List<User> users);
    @Mapping(source = "restaurantId", target = "restaurant.restaurantId")
    User toModel(UserDTO userDTO);
    List<User> toModels(List<UserDTO> userDTOs);


    //RESPONSE DTO

    @Mapping(source = "restaurant.restaurantId", target = "restaurantId")
    UserEntityResponseDTO toDTOResponse(User user);
    List<UserEntityResponseDTO> toDTOsResponse(List<User> users);
    @Mapping(source = "restaurantId", target = "restaurant.restaurantId")
    User toModelResponse(UserEntityResponseDTO userEntityResponseDTO);
    List<User> toModelsResponse(List<UserEntityResponseDTO> userEntityResponseDTOs);

}
