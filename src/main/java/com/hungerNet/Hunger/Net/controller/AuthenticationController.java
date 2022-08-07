package com.hungerNet.Hunger.Net.controller;


import com.hungerNet.Hunger.Net.dto.loginDTO.LoginDTO;
import com.hungerNet.Hunger.Net.dto.loginDTO.LoginResponseDTO;
import com.hungerNet.Hunger.Net.jwtUtil.JwtTokenUtil;
import com.hungerNet.Hunger.Net.service.UserService;
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
//        final UserDetails userDetails = getAuthenticationUserDetails(logU
//
//        final HttpHeaders headers = new HttpHeaders();
//        headers.add(tokenHeader, token);
//
//
//        final LoginResponseDTO responseElement = new LoginResponseDTO();
//        responseElement.setAccessToken(token);
//        responseElement.setTokenType("bearer");
////        responseElement.setRoles(userDetails.getAuthorities().stream().map(String::valueOf).toList());
//        responseElement.setRole2(userDetails.getAuthorities().stream().findFirst().toString());
        return userService.login(loginDTO);
    }

//    private UserDetails getAuthenticationUserDetails(final String username, final String password) {
//        // Perform the security
//        final Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return (UserDetails) authentication.getPrincipal();
//    }
}
