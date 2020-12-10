package com.codeBoard.authentication;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    @NotBlank
    private String userNameOrEmail;

    @NotBlank
    private String password;

}
