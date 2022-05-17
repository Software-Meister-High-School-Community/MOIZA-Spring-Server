package com.example.moizaspringserver.global.aws.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "aws")
public class AwsProperties {

	private final String accessKey;
	private final String secretKey;
	private final String sesSource;

	public AwsProperties(String accessKey, String secretKey, String sesSource) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.sesSource = sesSource;
	}
}
