package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.userDTO.RegisterUserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserDTO;
import com.hungerNet.Hunger.Net.enums.Roles;
import com.hungerNet.Hunger.Net.mapper.UserMapper;
import com.hungerNet.Hunger.Net.model.User;
import com.hungerNet.Hunger.Net.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;


    public UserDTO getUserById(UUID userId) {
        return userMapper.toDTO(userRepo.getReferenceById(userId));
    }
    public UserDTO getUserByUsername(String username) {
        return userMapper.toDTO(userRepo.getByUsername(username));
    }
    public List<UserDTO> getUsers() {
        return userMapper.toDTOs(userRepo.getUsers());
    }
    public List<UserDTO> getClientUsers() {
        return userMapper.toDTOs(userRepo.getClientUsers());
    }
    public List<UserDTO> getManagerUsers() {
        return userMapper.toDTOs(userRepo.getManagerUsers());
    }
    public UserDTO createUser(UserDTO userDTO){
        User createdUser = userMapper.toModel(userDTO);
        if (userDTO.getRestaurantId() == null) {
            createdUser.setRestaurant(null);
        }
        userRepo.save(createdUser);
        return userMapper.toDTO(createdUser);
    }
    public UserDTO register(RegisterUserDTO registerUserDTO){
        User createdUser = userMapper.toModelClient(registerUserDTO);
        createdUser.setRole(Roles.CLIENT);
        userRepo.save(createdUser);
        return userMapper.toDTO(createdUser);
    }
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userMapper.toModel(userDTO);
        userRepo.save(user);
        return userMapper.toDTO(user);
    }
    public void deleteUser(UUID userId) {
        userRepo.deleteById(userId);
    }
}
