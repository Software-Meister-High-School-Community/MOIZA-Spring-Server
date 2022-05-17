package com.example.moizaspringserver.domain.auth.service;

import com.example.moizaspringserver.domain.auth.presentation.dto.request.CheckAccountIdExistsRequest;
import com.example.moizaspringserver.domain.user.exception.UserAlreadyExistsException;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CheckAccountIdExistsService {

	private final UserRepository userRepository;

	@Transactional(readOnly = true)
	public void execute(CheckAccountIdExistsRequest request) {
		if (userRepository.findByAccountId(request.getAccountId()).isPresent()) {
			throw UserAlreadyExistsException.EXCEPTION;
		}
	}
}
