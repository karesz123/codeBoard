package com.codeBoard.security.user;

import com.codeBoard.model.entity.AccountUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class CredentialsUserFactory {

    public static User createCredentialsUserFromModelUser(AccountUser accountUser) {
        return new User(accountUser.getUserName(), accountUser.getPassword(), List.of(new SimpleGrantedAuthority(accountUser.getRole())));
    }
}
