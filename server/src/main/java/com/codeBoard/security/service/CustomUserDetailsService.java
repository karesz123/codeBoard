package com.codeBoard.security.service;

import com.codeBoard.repository.UserRepository;
import com.codeBoard.security.user.CredentialsUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return CredentialsUserFactory.createCredentialsUserFromModelUser(
                userRepository.findByUserName(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found with username:" + username)));
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        return CredentialsUserFactory.createCredentialsUserFromModelUser(
                userRepository.findById(id)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found with id:" + id)));
    }
}
