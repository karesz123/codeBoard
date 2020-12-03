package com.codeBoard.security.Jwt;

import lombok.Data;
import lombok.NonNull;

@Data
public class JwtAuthenticationResponse {

    @NonNull
    private String token;

}
