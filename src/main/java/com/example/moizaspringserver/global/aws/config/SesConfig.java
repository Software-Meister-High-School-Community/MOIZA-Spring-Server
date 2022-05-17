package com.example.moizaspringserver.global.aws.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient;
import com.example.moizaspringserver.global.aws.properties.AwsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class SesConfig {

	private final AwsProperties awsProperties;

	@Bean
	public AmazonSimpleEmailServiceAsync amazonSimpleEmailService() {
		BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(awsProperties.getAccessKey(),
			awsProperties.getSecretKey());

		return AmazonSimpleEmailServiceAsyncClient.asyncBuilder()
			.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
			.withRegion(Regions.AP_NORTHEAST_2)
			.build();
	}
}
