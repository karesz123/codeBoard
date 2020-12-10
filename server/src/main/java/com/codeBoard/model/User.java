package com.codeBoard.model;

import com.codeBoard.model.entity.AccountUser;
import lombok.Data;

@Data
public class User {

    private String name;
    private String userName;
    private String email;

    public User(AccountUser accountUser) {
        setName(accountUser.getName());
        setUserName(accountUser.getUserName());
        setEmail(accountUser.getEmail());
    }
}
