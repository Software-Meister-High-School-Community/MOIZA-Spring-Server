package com.example.moizaspringserver.domain.auth.service;

import com.example.moizaspringserver.domain.auth.entity.EmailCode;
import com.example.moizaspringserver.domain.auth.entity.EmailCodeLimit;
import com.example.moizaspringserver.domain.auth.exception.EmailCodeRequestOverLimitException;
import com.example.moizaspringserver.domain.auth.presentation.dto.request.SendEmailAuthCodeRequest;
import com.example.moizaspringserver.domain.auth.presentation.dto.response.SendEmailCodeResponse;
import com.example.moizaspringserver.domain.auth.repository.EmailCodeLimitRepository;
import com.example.moizaspringserver.domain.auth.repository.EmailCodeRepository;
import com.example.moizaspringserver.domain.auth.type.Type;
import com.example.moizaspringserver.domain.user.exception.UserNotFoundException;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import com.example.moizaspringserver.global.aws.util.SesUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SendEmailAuthCodeService {

	private final UserRepository userRepository;
	private final EmailCodeRepository emailCodeRepository;
	private final EmailCodeLimitRepository emailCodeLimitRepository;
	private final SesUtil sesUtil;

	@Transactional
	public SendEmailCodeResponse execute(SendEmailAuthCodeRequest request) {

		final String email;

		if (request.getType().equals(Type.PASSWORD)) {
			email = userRepository.findByAccountId(request.getValue())
				.orElseThrow(() -> UserNotFoundException.EXCEPTION)
				.getEmail();
		} else {
			email = request.getValue();
		}
		isOverLimit(email,request.getType());

		String authCode = RandomStringUtils.randomNumeric(6);

		emailCodeRepository.findById(email)
			.ifPresentOrElse(
				emailCode -> emailCode.updateAuthCode(authCode),
				() -> buildEmailCode(email, authCode, request.getType())
			);

		sesUtil.sendMail(email, authCode);

		return new SendEmailCodeResponse(email);
	}

	private void isOverLimit(String email, Type type) {
		emailCodeLimitRepository.findById(email)
			.filter(limit -> checkCount(limit.getCount()))
			.map(EmailCodeLimit::addCount)
			.map(emailCodeLimitRepository::save)
			.orElseGet(() -> emailCodeLimitRepository.save(EmailCodeLimit.builder()
				.email(email)
				.type(type)
				.build()));
	}

	private boolean checkCount(int count) {
		if (count >= 5) {
			throw EmailCodeRequestOverLimitException.EXCEPTION;
		}
		return true;
	}

	private void buildEmailCode(String email, String authCode, Type type) {
		emailCodeRepository.save(
			EmailCode.builder()
				.email(email)
				.authCode(authCode)
				.type(type)
				.build()
		);
	}
}
