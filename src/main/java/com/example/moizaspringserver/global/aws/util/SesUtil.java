package com.example.moizaspringserver.global.aws.util;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.example.moizaspringserver.global.aws.properties.AwsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SesUtil {

	private final AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync;
	private final AwsProperties awsProperties;

	public void sendMail(String email, String authCode) {
		Message message = new Message()
			.withSubject(createContent("test"))
			.withBody(new Body()
				.withHtml(createContent(authCode)));

		SendEmailRequest request = new SendEmailRequest()
			.withDestination(new Destination().withToAddresses(email))
			.withSource(awsProperties.getSesSource())
			.withMessage(message);

		amazonSimpleEmailServiceAsync.sendEmailAsync(request);
	}

	private Content createContent(String text) {
		return new Content()
			.withCharset("UTF-8")
			.withData(text);
	}
}
