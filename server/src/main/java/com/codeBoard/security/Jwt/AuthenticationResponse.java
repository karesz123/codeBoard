package com.codeBoard.security.Jwt;

import lombok.Data;
import lombok.NonNull;

@Data
public class AuthenticationResponse {

    @NonNull
    private String token;

}
