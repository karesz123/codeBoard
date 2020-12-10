package com.codeBoard.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public Authentication authenticate(String userNameOrEmail, String password, Collection<? extends GrantedAuthority> authorities) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userNameOrEmail,
                        password,
                        authorities
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }

    public Authentication authenticate(UserDetails userDetails) {
        return authenticate(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }
}
