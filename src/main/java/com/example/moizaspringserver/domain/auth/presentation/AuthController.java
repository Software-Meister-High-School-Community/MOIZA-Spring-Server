package com.example.moizaspringserver.domain.auth.presentation;

import com.example.moizaspringserver.domain.auth.presentation.dto.request.CheckAccountIdExistsRequest;
import com.example.moizaspringserver.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.moizaspringserver.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.moizaspringserver.domain.auth.service.CheckAccountIdExistsService;
import com.example.moizaspringserver.domain.auth.service.TokenRefreshService;
import com.example.moizaspringserver.domain.auth.service.UserSignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final TokenRefreshService tokenRefreshService;
    private final UserSignInService userSignInService;
    private final CheckAccountIdExistsService checkAccountIdExistsService;

    @PutMapping("/tokens")
    public UserTokenRefreshResponse userTokenRefresh(@RequestHeader("Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }

    @PostMapping("/tokens")
    public UserTokenRefreshResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }

    @RequestMapping(value = "/id-validations", method = RequestMethod.HEAD)
    public void checkAccountIdExists(@RequestBody @Valid CheckAccountIdExistsRequest request) {
        checkAccountIdExistsService.execute(request);
    }

}
