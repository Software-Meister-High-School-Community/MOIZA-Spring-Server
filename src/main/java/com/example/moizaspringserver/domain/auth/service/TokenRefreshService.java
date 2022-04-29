package com.example.moizaspringserver.domain.auth.service;

import com.example.moizaspringserver.domain.auth.entity.RefreshToken;
import com.example.moizaspringserver.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.moizaspringserver.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.moizaspringserver.domain.auth.repository.RefreshTokenRepository;
import com.example.moizaspringserver.global.security.properties.JwtProperties;
import com.example.moizaspringserver.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TokenRefreshService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public UserTokenRefreshResponse execute(String refreshToken) {
        RefreshToken redisRefreshToken = refreshTokenRepository.findByRefreshToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(redisRefreshToken.getUserId());
        redisRefreshToken.updateRefreshToken(newRefreshToken, jwtProperties.getRefreshExp());

        String accessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.getUserId());
        return UserTokenRefreshResponse.builder()
                .accessToken(accessToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .refreshToken(newRefreshToken)
                .build();
    }
}
