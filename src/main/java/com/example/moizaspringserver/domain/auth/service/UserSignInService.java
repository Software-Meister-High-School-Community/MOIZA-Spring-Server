package com.example.moizaspringserver.domain.auth.service;

import com.example.moizaspringserver.domain.auth.exception.PasswordMismatchException;
import com.example.moizaspringserver.domain.auth.facade.AuthFacade;
import com.example.moizaspringserver.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.moizaspringserver.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.entity.UserDeviceToken;
import com.example.moizaspringserver.domain.user.exception.UserNotFoundException;
import com.example.moizaspringserver.domain.user.repository.UserDeviceTokenRepository;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import com.example.moizaspringserver.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignInService {

    private final UserRepository userRepository;
    private final UserDeviceTokenRepository userDeviceTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthFacade authFacade;

    @Transactional
    public UserTokenRefreshResponse execute(UserSignInRequest request) {

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        UserDeviceToken userDeviceToken = UserDeviceToken.builder()
                .appDeviceToken(request.getAppDeviceToken())
                .webDeviceToken(request.getWebDeviceToken())
                .user(user)
                .build();

        authFacade.passwordMatch(user, request);

        userDeviceTokenRepository.save(userDeviceToken);

        String accessToken = jwtTokenProvider.generateAccessToken(user.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getAccountId());

        return UserTokenRefreshResponse.builder()
                .accessToken(accessToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .refreshToken(refreshToken)
                .build();
    }
}
