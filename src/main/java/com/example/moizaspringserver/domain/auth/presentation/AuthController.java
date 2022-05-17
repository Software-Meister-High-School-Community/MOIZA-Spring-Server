package com.example.moizaspringserver.domain.auth.presentation;

import com.example.moizaspringserver.domain.auth.presentation.dto.request.SendEmailAuthCodeRequest;
import com.example.moizaspringserver.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.moizaspringserver.domain.auth.presentation.dto.response.SendEmailCodeResponse;
import com.example.moizaspringserver.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.moizaspringserver.domain.auth.service.SendEmailAuthCodeService;
import com.example.moizaspringserver.domain.auth.service.TokenRefreshService;
import com.example.moizaspringserver.domain.auth.service.UserSignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final TokenRefreshService tokenRefreshService;
    private final UserSignInService userSignInService;
    private final SendEmailAuthCodeService sendEmailAuthCodeService;

    @PutMapping("/tokens")
    public UserTokenRefreshResponse userTokenRefresh(@RequestHeader("Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }

    @PostMapping("/tokens")
    public UserTokenRefreshResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/email-verifications")
    public SendEmailCodeResponse sendEmailAuthCode(@RequestBody @Valid SendEmailAuthCodeRequest request) {
        return sendEmailAuthCodeService.execute(request);
    }

}
