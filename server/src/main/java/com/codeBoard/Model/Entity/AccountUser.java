package com.codeBoard.Model.Entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "\"account_user\"")
public class AccountUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    @Column(unique=true)
    private String userName;
    @Column(unique=true)
    private String email;
    private String password;
    private String role;

    protected AccountUser() {
    }

    public AccountUser(String name, String userName, String email) {
        this.name = name;
        this.userName = userName;
        this.email = email;
    }
}
