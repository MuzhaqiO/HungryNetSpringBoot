package com.hungerNet.Hunger.Net.controller;


import com.hungerNet.Hunger.Net.dto.loginDTO.LoginDTO;
import com.hungerNet.Hunger.Net.jwtUtil.JwtTokenUtil;
import com.hungerNet.Hunger.Net.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "hunger_net")
@RequiredArgsConstructor
public class AuthenticationController {
    @Value("${security.jwt.header:Authorization}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final UserService userService;

    @PostMapping("login")
    ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }
}
