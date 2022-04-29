package com.example.moizaspringserver.domain.auth.service;

import com.example.moizaspringserver.domain.auth.exception.PasswordMismatchException;
import com.example.moizaspringserver.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.moizaspringserver.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.exception.UserNotFoundException;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import com.example.moizaspringserver.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignInService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public UserTokenRefreshResponse execute(UserSignInRequest request) {

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        user.setDeviceToken(request.getWebpDeviceToken(), request.getAppDeviceToken());

        String accessToken = jwtTokenProvider.generateAccessToken(user.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getAccountId());

        return UserTokenRefreshResponse.builder()
                .accessToken(accessToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .refreshToken(refreshToken)
                .build();
    }
}
