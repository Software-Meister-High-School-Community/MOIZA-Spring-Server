package com.example.moizaspringserver.domain.auth.service;

import com.example.moizaspringserver.domain.auth.entity.EmailCode;
import com.example.moizaspringserver.domain.auth.entity.EmailCodeLimit;
import com.example.moizaspringserver.domain.auth.exception.AuthCodeAlreadyVerifiedException;
import com.example.moizaspringserver.domain.auth.exception.EmailCodeRequestOverLimitException;
import com.example.moizaspringserver.domain.auth.presentation.dto.request.SendEmailAuthCodeRequest;
import com.example.moizaspringserver.domain.auth.presentation.dto.response.SendEmailAuthCodeResponse;
import com.example.moizaspringserver.domain.auth.repository.EmailCodeLimitRepository;
import com.example.moizaspringserver.domain.auth.repository.EmailCodeRepository;
import com.example.moizaspringserver.domain.auth.type.Type;
import com.example.moizaspringserver.domain.user.exception.UserNotFoundException;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import com.example.moizaspringserver.global.aws.util.SesUtil;
import java.util.Optional;
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
	public SendEmailAuthCodeResponse execute(SendEmailAuthCodeRequest request) {

		Type type = request.getType();
		String value = request.getValue();
		String email = getEmail(type, value);

		Optional<EmailCode> emailCode = emailCodeRepository.findByEmailAndType(email, type);

		emailCode.ifPresent(code -> checkVerify(code.isVerify()));
		isOverLimit(email, type);

		String authCode = RandomStringUtils.randomNumeric(6);

		emailCode.ifPresentOrElse(
			code -> code.updateAuthCode(authCode),
			() -> buildEmailCode(email, authCode, request.getType())
		);

		sesUtil.sendMail(email, authCode);

		return new SendEmailAuthCodeResponse(email);
	}

	private String getEmail(Type type, String value) {
		if (Type.PASSWORD.equals(type)) {
			return userRepository.findByAccountId(value)
				.orElseThrow(() -> UserNotFoundException.EXCEPTION)
				.getEmail();
		} else {
			return value;
		}
	}

	private void checkVerify(boolean isVerify) {
		if (isVerify) {
			throw AuthCodeAlreadyVerifiedException.EXCEPTION;
		}
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
