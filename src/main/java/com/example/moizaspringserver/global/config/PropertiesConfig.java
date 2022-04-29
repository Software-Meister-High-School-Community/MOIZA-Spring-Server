package com.example.moizaspringserver.global.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@ConfigurationPropertiesScan("com.example.moizaspringserver.global.security.properties")
@Configuration
public class PropertiesConfig { }
