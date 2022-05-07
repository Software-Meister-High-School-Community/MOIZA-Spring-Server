package com.example.moizaspringserver.domain.user.presentation;

import com.example.moizaspringserver.domain.user.presentation.dto.request.UserSingUpRequest;
import com.example.moizaspringserver.domain.user.service.UserSingUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

	private final UserSingUpService userSingUpService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void singUp(@RequestBody UserSingUpRequest userSingUpRequest) {
		userSingUpService.execute(userSingUpRequest);
	}
}
