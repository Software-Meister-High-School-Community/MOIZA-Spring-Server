package com.example.moizaspringserver.global.security;

import com.example.moizaspringserver.domain.auth.entity.RefreshToken;
import com.example.moizaspringserver.domain.auth.repository.RefreshTokenRepository;
import com.example.moizaspringserver.global.error.security.ExpiredTokenException;
import com.example.moizaspringserver.global.error.security.InvalidTokenException;
import com.example.moizaspringserver.global.security.auth.AuthDetailsService;
import com.example.moizaspringserver.global.security.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    public static final String ACCESS_KEY = "access";
    public static final String REFRESH_KEY = "refresh";

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;

    public String generateAccessToken(String id) {
        return generateToken(id, ACCESS_KEY, jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String id) {
        String refreshToken = generateToken(id, REFRESH_KEY, jwtProperties.getRefreshExp());
        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(id)
                .refreshToken(refreshToken)
                .build());
        return refreshToken;
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())) {
            return bearerToken.replace(jwtProperties.getPrefix(), "");
        }
        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix()))
            return bearerToken.replace(jwtProperties.getPrefix(), "");
        return null;
    }

    private Claims getTokenBody(String token) {

        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredTokenException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (SignatureException e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    private String generateToken(String id, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(id)
                .claim("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public LocalDateTime getExpiredTime() {
        return LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp());
    }
}
