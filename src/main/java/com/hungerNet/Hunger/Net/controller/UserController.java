package com.hungerNet.Hunger.Net.controller;

import com.hungerNet.Hunger.Net.dto.userDTO.UserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserEntityResponseDTO;
import com.hungerNet.Hunger.Net.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
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
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<List<UserEntityResponseDTO>> findAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("getAllClients")
    public ResponseEntity<List<UserEntityResponseDTO>> findAllClientUsers() {
        return ResponseEntity.ok(userService.getClientUsers());
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("getAllManagers")
    public ResponseEntity<List<UserEntityResponseDTO>> findAllManagerUsers() {
        return ResponseEntity.ok(userService.getManagerUsers());
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("userId/{userId}")
    public ResponseEntity<UserEntityResponseDTO> getUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @GetMapping("username/{username}")
    public ResponseEntity<UserEntityResponseDTO> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @PostMapping("createUser")
    public ResponseEntity<UserEntityResponseDTO> createUser(@RequestBody UserDTO userDTO){
        UserEntityResponseDTO user = userService.createUser(userDTO);
        return ResponseEntity.ok().body(user);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @PutMapping("updateUser/{userId}")
    public ResponseEntity<UserEntityResponseDTO> updateUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userId, userDTO));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "JWT")})
    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
    }
}
