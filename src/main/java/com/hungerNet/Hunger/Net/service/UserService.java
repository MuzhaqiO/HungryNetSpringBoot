package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.loginDTO.LoginDTO;
import com.hungerNet.Hunger.Net.dto.loginDTO.LoginResponseDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserEntityResponseDTO;
import com.hungerNet.Hunger.Net.enums.RoleName2;
import com.hungerNet.Hunger.Net.jwtUtil.JwtTokenUtil;
import com.hungerNet.Hunger.Net.mapper.UserMapper;
import com.hungerNet.Hunger.Net.model.Role;
import com.hungerNet.Hunger.Net.model.User;
import com.hungerNet.Hunger.Net.repository.RoleRepo;
import com.hungerNet.Hunger.Net.repository.UserRepo;
import com.hungerNet.Hunger.Net.security.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${security.jwt.header:Authorization}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    public UserEntityResponseDTO getUserById(UUID userId) {
        return userMapper.toDTOResponse(userRepo.getReferenceById(userId));
    }
    public UserEntityResponseDTO getUserByUsername(String username) {
        return userMapper.toDTOResponse(userRepo.getByUsername(username));
    }

    public List<UserEntityResponseDTO> getUsers() {
        return userMapper.toDTOsResponse(userRepo.getUsers());
    }
//    public List<UserDTO> getClientUsers() {
//        return userMapper.toDTOs(userRepo.getClientUsers());
//    }
//    public List<UserDTO> getManagerUsers() {
//        return userMapper.toDTOs(userRepo.getManagerUsers());
//    }

    public UserEntityResponseDTO createUser(UserDTO userDTO){
       User createdUser = userMapper.toModel(userDTO);
        if (userDTO.getRestaurantId() == null) {
            createdUser.setRestaurant(null);
        }
        createdUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        createdUser.setRoleName2(RoleName2.valueOf(userDTO.getRole2()));
        UserEntityResponseDTO responseDTO = userMapper.toDTOResponse(userRepo.save(createdUser));
        responseDTO.setRole2(createdUser.getRoleName2());
        return responseDTO;
    }

    public UserEntityResponseDTO updateUser(UUID userId, UserDTO userDTO) {
        User currentUser = userRepo.getReferenceById(userId);
        currentUser.setUsername(userDTO.getUsername());
        currentUser.setRoleName2(RoleName2.valueOf(userDTO.getRole2()));
        return userMapper.toDTOResponse(userRepo.save(currentUser));
    }
    public void deleteUser(UUID userId) {
        userRepo.deleteById(userId);
    }

    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        final UserDetails userDetails = getAuthenticationUserDetails(loginDTO.getUsername(), loginDTO.getPassword());
        final String token = jwtTokenUtil.generateToken(userDetails);
        final HttpHeaders headers = new HttpHeaders();
        headers.add(tokenHeader, token);

        final LoginResponseDTO responseElement = new LoginResponseDTO();
        responseElement.setAccessToken(token);
        responseElement.setTokenType("bearer");
//        responseElement.setRoles(userDetails.getAuthorities().stream().map(String::valueOf).toList());
        responseElement.setRole2(userDetails.getAuthorities().stream().findFirst().toString());
        return new ResponseEntity<>(responseElement, headers, HttpStatus.OK);
    }

    private UserDetails getAuthenticationUserDetails(final String username, final String password) {
        // Perform the security
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return (UserDetails) authentication.getPrincipal();
    }

}
