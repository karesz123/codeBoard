package com.codeBoard.controller;

import com.codeBoard.authentication.LoginRequest;
import com.codeBoard.authentication.SignUpRequest;
import com.codeBoard.model.entity.AccountUser;
import com.codeBoard.response.ApiResponse;
import com.codeBoard.service.UserService;
import com.codeBoard.security.Jwt.AuthenticationEntry;
import com.codeBoard.security.Jwt.AuthenticationResponse;
import com.codeBoard.security.Jwt.TokenProvider;
import com.codeBoard.security.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserService userService;


    private static final Logger logger = LoggerFactory.getLogger(AuthenticationEntry.class);

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication =  authService.authenticate(loginRequest.getUserNameOrEmail(),
                        loginRequest.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("USER")));
        return ResponseEntity.ok(new AuthenticationResponse(tokenProvider.generateToken(authentication)));
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
