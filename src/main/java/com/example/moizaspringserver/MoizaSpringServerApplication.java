package com.example.moizaspringserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MoizaSpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoizaSpringServerApplication.class, args);
	}

}
