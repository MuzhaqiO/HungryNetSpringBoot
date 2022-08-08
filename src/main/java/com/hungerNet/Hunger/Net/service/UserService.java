package com.hungerNet.Hunger.Net.service;

import com.hungerNet.Hunger.Net.dto.loginDTO.LoginDTO;
import com.hungerNet.Hunger.Net.dto.loginDTO.LoginResponseDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserDTO;
import com.hungerNet.Hunger.Net.dto.userDTO.UserEntityResponseDTO;
import com.hungerNet.Hunger.Net.enums.RoleName;
import com.hungerNet.Hunger.Net.jwtUtil.JwtTokenFilter;
import com.hungerNet.Hunger.Net.jwtUtil.JwtTokenUtil;
import com.hungerNet.Hunger.Net.mapper.UserMapper;
import com.hungerNet.Hunger.Net.model.User;
import com.hungerNet.Hunger.Net.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
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

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

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
        try {
            return userMapper.toDTOResponse(userRepo.getReferenceById(userId));
        } catch (EntityNotFoundException e) {
            LOGGER.error("User Id '{}' does not exist", userId);
            throw e;
        }

    }
    public UserEntityResponseDTO getUserByUsername(String username) {
        User user = userRepo.getByUsername(username);
        if (user == null) {
            LOGGER.error("User with username '{}' not found", username);
            throw new EntityNotFoundException();
        }
        return userMapper.toDTOResponse(user);
    }

    public List<UserEntityResponseDTO> getUsers() {
        return userMapper.toDTOsResponse(userRepo.getUsers());
    }
    public List<UserEntityResponseDTO> getClientUsers() {
        return userMapper.toDTOsResponse(userRepo.getClientUsers());
    }
    public List<UserEntityResponseDTO> getManagerUsers() {
        return userMapper.toDTOsResponse(userRepo.getManagerUsers());
    }

    public UserEntityResponseDTO createUser(UserDTO userDTO){
        try {
            User createdUser = userMapper.toModel(userDTO);
            if (userDTO.getRestaurantId() == null) {
                createdUser.setRestaurant(null);
            }
            createdUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            createdUser.setRoleName(RoleName.valueOf(userDTO.getRole()));
            UserEntityResponseDTO responseDTO = userMapper.toDTOResponse(userRepo.save(createdUser));
            responseDTO.setRoleName(createdUser.getRoleName());
            return responseDTO;
        }
        catch (Exception ex){
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }

    public UserEntityResponseDTO updateUser(UUID userId, UserDTO userDTO) {
        try {
            User currentUser = userRepo.getReferenceById(userId);
            currentUser.setUsername(userDTO.getUsername());
            currentUser.setRoleName(RoleName.valueOf(userDTO.getRole()));
            return userMapper.toDTOResponse(userRepo.save(currentUser));
        } catch (IllegalArgumentException e) {
            LOGGER.error("Couldn't update user");
            throw new RuntimeException(e);
        }

    }
    public void deleteUser(UUID userId) {
        try {
            userRepo.deleteById(userId);
        }
        catch (EmptyResultDataAccessException e){
            LOGGER.error("User Id '{}' doesn't exist", userId);
            throw e;
        }
    }

    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        final UserDetails userDetails = getAuthenticationUserDetails(loginDTO.getUsername(), loginDTO.getPassword());
        final String token = jwtTokenUtil.generateToken(userDetails);
        final HttpHeaders headers = new HttpHeaders();
        headers.add(tokenHeader, token);

        final LoginResponseDTO responseElement = new LoginResponseDTO();
        responseElement.setAccessToken(token);
        responseElement.setTokenType("bearer");
        responseElement.setRole2(userDetails.getAuthorities().stream().findFirst().toString());
        return new ResponseEntity<>(responseElement, headers, HttpStatus.OK);
    }

    private UserDetails getAuthenticationUserDetails(final String username, final String password) {
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return (UserDetails) authentication.getPrincipal();
    }

}
