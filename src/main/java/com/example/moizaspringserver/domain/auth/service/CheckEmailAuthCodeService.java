package com.example.moizaspringserver.domain.auth.service;

import com.example.moizaspringserver.domain.auth.entity.EmailCode;
import com.example.moizaspringserver.domain.auth.exception.InvalidAuthCodeException;
import com.example.moizaspringserver.domain.auth.presentation.dto.request.CheckEmailAuthCodeRequest;
import com.example.moizaspringserver.domain.auth.repository.EmailCodeRepository;
import com.example.moizaspringserver.domain.user.exception.EmailCodeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CheckEmailAuthCodeService {

	private final EmailCodeRepository emailCodeRepository;

	@Transactional
	public void execute(CheckEmailAuthCodeRequest request) {
		
		EmailCode emailCode = emailCodeRepository.findByEmailAndType(request.getEmail(), request.getType())
			.orElseThrow(() -> EmailCodeNotFoundException.EXCEPTION);

		if (!emailCode.getAuthCode().equals(request.getAuthCode())) {
			throw InvalidAuthCodeException.EXCEPTION;
		}

		emailCode.checkAuthCode();
	}
}
