package com.example.moizaspringserver.global.security;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collection;

@Getter
public class JwtTokenAuthentication extends AbstractAuthenticationToken {

    private final String jwtToken;
    public JwtTokenAuthentication(String jwtToken, Boolean authenticated) {
        super((Collection)null);
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
