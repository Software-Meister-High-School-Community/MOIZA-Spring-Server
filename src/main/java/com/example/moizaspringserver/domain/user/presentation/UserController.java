package com.example.moizaspringserver.domain.user.presentation;

import com.example.moizaspringserver.domain.user.presentation.dto.request.UpdateMyInfoRequest;
import com.example.moizaspringserver.domain.user.presentation.dto.request.UserSingUpRequest;
import com.example.moizaspringserver.domain.user.service.UpdateMyInfoService;
import com.example.moizaspringserver.domain.user.service.UserSingUpService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

	private final UserSingUpService userSingUpService;
	private final UpdateMyInfoService updateMyInfoService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void singUp(@RequestBody @Valid UserSingUpRequest userSingUpRequest) {
		userSingUpService.execute(userSingUpRequest);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PatchMapping
	public void updateMyInfo(@RequestBody @Valid UpdateMyInfoRequest request) {
		updateMyInfoService.execute(request);
	}
}
