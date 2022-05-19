package com.example.moizaspringserver.domain.auth.service;

import com.example.moizaspringserver.domain.auth.facade.AuthFacade;
import com.example.moizaspringserver.domain.auth.presentation.dto.request.CheckAccountIdExistsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CheckAccountIdExistsService {

	private final AuthFacade authFacade;

	@Transactional(readOnly = true)
	public void execute(CheckAccountIdExistsRequest request) {
		authFacade.checkUserExistsByAccountId(request.getAccountId());
	}
}
