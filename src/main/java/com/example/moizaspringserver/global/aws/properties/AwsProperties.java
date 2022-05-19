package com.example.moizaspringserver.global.aws.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "aws")
public class AwsProperties {

	private final String accessKey;
	private final String secretKey;
	private final String sesSource;
}
