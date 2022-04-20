package com.example.moizaspringserver.global.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "jwt")
@Component
@Getter
@RequiredArgsConstructor
public class JwtProperties {
    private final String secret;
}
