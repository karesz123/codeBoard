package com.codeBoard.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank @Size(min = 2, max = 15)
    private String name;

    @NotBlank @Size(min = 2, max = 15)
    private String userName;

    @NotBlank @Size(max = 40)
    private String email;

    @NotBlank @Size(min = 4, max = 15)
    private String password;

    public SignUpRequest() {

    }
}
