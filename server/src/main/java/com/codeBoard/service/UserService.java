package com.codeBoard.service;

import com.codeBoard.authentication.SignUpRequest;
import com.codeBoard.model.entity.AccountUser;
import com.codeBoard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public AccountUser createUser(SignUpRequest signUpRequest) throws Exception {
        AccountUser accountUser = new AccountUser(signUpRequest.getName(), signUpRequest.getUserName(), signUpRequest.getEmail());
        accountUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        accountUser.setRole("USER");
        return userRepository.save(accountUser);
    }
}
