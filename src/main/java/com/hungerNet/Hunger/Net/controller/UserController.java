package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.userDTO.RegisterUserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserEntityResponseDTO;
import com.hungerNet.Hunger.Net.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "hunger_net/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserEntityResponseDTO>> findAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
//    @GetMapping("getAllClients")
//    public ResponseEntity<List<UserDTO>> findAllClientUsers() {
//        return ResponseEntity.ok(userService.getClientUsers());
//    }
//    @GetMapping("getAllManagers")
//    public ResponseEntity<List<UserDTO>> findAllManagerUsers() {
//        return ResponseEntity.ok(userService.getManagerUsers());
//    }
    @GetMapping("userId/{userId}")
    public ResponseEntity<UserEntityResponseDTO> getUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
    @GetMapping("username/{username}")
    public ResponseEntity<UserEntityResponseDTO> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
    @PostMapping("createUser")
    public ResponseEntity<UserEntityResponseDTO> createUser(@RequestBody UserDTO userDTO){
        UserEntityResponseDTO user = userService.createUser(userDTO);
        return ResponseEntity.ok().body(user);
    }
    @PutMapping("updateUser/{userId}")
    public ResponseEntity<UserEntityResponseDTO> updateUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userId, userDTO));
    }
    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
    }
}
