package com.codeBoard.controllers;

import com.codeBoard.Model.User;
import com.codeBoard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return new User(userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User with username: " + username + " not found")));
    }
}
