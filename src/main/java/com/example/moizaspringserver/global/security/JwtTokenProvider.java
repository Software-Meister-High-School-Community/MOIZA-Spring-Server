package com.example.moizaspringserver.global.security;

import com.example.moizaspringserver.global.config.JwtProperties;
import com.example.moizaspringserver.global.error.security.InvalidTokenException;
import com.example.moizaspringserver.global.error.security.NoTokenServedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String SECRET_JWT;
    public JwtTokenProvider(JwtProperties jwtProperties) {
        SECRET_JWT = jwtProperties.getSecret();
    }

    public String generate(Authentication auth) {
        Date now = new Date();
        Date expiresAt = new Date(now.getTime() + (1000 * 60 * 60 * 2)); // Expires after 2 days

        return Jwts.builder()
                .setSubject((String) auth.getPrincipal())
                .setIssuedAt(now)
                .setExpiration(expiresAt)
                .signWith(SignatureAlgorithm.HS256, SECRET_JWT)
                .compact();
    }

    private Jws<Claims> parseToken(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(SECRET_JWT)
                .parseClaimsJws(jwtToken);
    }

    public String getUserId(String jwtToken) {
        Claims claims = parseToken(jwtToken).getBody();
        return claims.getSubject();
    }

    public void validation(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) throw new NoTokenServedException();

        try {
            parseToken(jwtToken);
        } catch (Exception ex) {
            throw new InvalidTokenException();
        }
    }

}