package com.codeBoard.security.Jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private String jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date dateCreated = new Date();
        return Jwts.builder().setSubject(user.getUsername())
                .setIssuedAt(dateCreated)
                .setExpiration(calculateExpirationDate(dateCreated))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Long getUserIdFromJwt(String token) {
        return Long.parseLong(Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return false;
    }

    private Date calculateExpirationDate(Date dateCreated) {
        return new Date(dateCreated.getTime() + jwtExpirationInMs);
    }
}
