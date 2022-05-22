package com.example.moizaspringserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class MoizaSpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoizaSpringServerApplication.class, args);
	}

}
