package com.example.moizaspringserver.domain.auth.presentation;

import com.example.moizaspringserver.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.moizaspringserver.domain.auth.service.TokenRefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auths")
@RestController
public class AuthController {

    private final TokenRefreshService tokenRefreshService;

    @PutMapping("/token")
    public UserTokenRefreshResponse userTokenRefresh(@RequestHeader("x-refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }

}