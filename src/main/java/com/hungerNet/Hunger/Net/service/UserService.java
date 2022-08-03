package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.UserDTO;
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
        return userMapper.toDTOs(userRepo.findAll());
    }
    public UserDTO addNewUser(UserDTO userDTO){
        User createdUser = userRepo.save(userMapper.toModel(userDTO));
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
