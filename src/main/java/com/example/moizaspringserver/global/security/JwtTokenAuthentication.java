package com.example.moizaspringserver.global.security;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collection;

@Getter
public class JwtTokenAuthentication extends UsernamePasswordAuthenticationToken {

    private final String jwtToken;
    public JwtTokenAuthentication(String jwtToken, Boolean authenticated) {
        super(null, null, (Collection)null);
        this.jwtToken = jwtToken;
        this.setAuthenticated(authenticated);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
