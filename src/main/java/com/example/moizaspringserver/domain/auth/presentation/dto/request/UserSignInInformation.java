package com.example.moizaspringserver.domain.auth.presentation.dto.request;

import com.example.moizaspringserver.domain.auth.exception.PasswordMismatchException;
import com.example.moizaspringserver.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserSignInInformation {

    private final PasswordEncoder passwordEncoder;

    public void passwordMatch(User user, UserSignInRequest request) {
        if (!passwordEncoder.matches(user.getPassword(), request.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

    }

}