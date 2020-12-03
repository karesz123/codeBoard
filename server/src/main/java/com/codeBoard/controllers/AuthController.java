package com.codeBoard.controllers;

import com.codeBoard.Authentication.LoginRequest;
import com.codeBoard.Authentication.SignUpRequest;
import com.codeBoard.Model.Entity.AccountUser;
import com.codeBoard.Response.ApiResponse;
import com.codeBoard.Service.UserService;
import com.codeBoard.security.Jwt.JwtAuthenticationEntryPoint;
import com.codeBoard.security.Jwt.JwtAuthenticationResponse;
import com.codeBoard.security.Jwt.JwtTokenProvider;
import com.codeBoard.security.UserAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = new UserAuthentication()
                .authenticate(loginRequest.getUserNameOrEmail(), loginRequest.getPassword(), null);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwtTokenProvider.generateToken(authentication)));
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequest signUpRequest) throws Exception {
        AccountUser accountUser = userService.createUser(signUpRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(accountUser.getUserName()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
