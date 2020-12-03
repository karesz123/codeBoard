package com.codeBoard.Service;

import com.codeBoard.Authentication.SignUpRequest;
import com.codeBoard.Model.Entity.AccountUser;
import com.codeBoard.Repository.UserRepository;
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
