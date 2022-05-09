package com.example.moizaspringserver.domain.user.service;

import com.example.moizaspringserver.domain.auth.entity.EmailCode;
import com.example.moizaspringserver.domain.auth.repository.EmailCodeRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.exception.EmailCodeNotFoundException;
import com.example.moizaspringserver.domain.user.exception.EmailCodeNotVerifiedException;
import com.example.moizaspringserver.domain.user.exception.UserAlreadyExistsException;
import com.example.moizaspringserver.domain.user.presentation.dto.request.UserSingUpRequest;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSingUpService {

	private final UserRepository userRepository;
	private final EmailCodeRepository emailCodeRepository;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	public void execute(UserSingUpRequest request) {

		if (userRepository.findByAccountId(request.getAccountId()).isPresent() ||
			userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw UserAlreadyExistsException.EXCEPTION;
		}

		EmailCode emailCode = emailCodeRepository.findById(request.getEmail())
			.orElseThrow(() -> EmailCodeNotFoundException.EXCEPTION);

		if (!emailCode.isVerify()) {
			throw EmailCodeNotVerifiedException.EXCEPTION;
		}

		User user = User.builder()
			.accountId(request.getAccountId())
			.password(passwordEncoder.encode(request.getPassword()))
			.email(request.getEmail())
			.name(request.getName())
			.birthDay(request.getBirthday())
			.sex(request.getSex())
			.userType(request.getUserType())
			.school(request.getSchool())
			.build();

		userRepository.save(user);
	}
}
