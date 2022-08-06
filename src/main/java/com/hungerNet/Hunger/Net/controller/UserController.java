package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.userDTO.RegisterUserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserDTO;
import com.hungerNet.Hunger.Net.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    @GetMapping("getAll")
//    public ResponseEntity<List<UserDTO>> findAllUsers() {
//        return ResponseEntity.ok(userService.getUsers());
//    }
//    @GetMapping("getAllClients")
//    public ResponseEntity<List<UserDTO>> findAllClientUsers() {
//        return ResponseEntity.ok(userService.getClientUsers());
//    }
//    @GetMapping("getAllManagers")
//    public ResponseEntity<List<UserDTO>> findAllManagerUsers() {
//        return ResponseEntity.ok(userService.getManagerUsers());
//    }
    @GetMapping("userId/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
    @GetMapping("username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
    @PostMapping("register")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterUserDTO registerUserDTO){
        return ResponseEntity.ok(userService.register(registerUserDTO));
    }
    @PostMapping("createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
    @PutMapping("updateUser")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }
    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
    }
}
