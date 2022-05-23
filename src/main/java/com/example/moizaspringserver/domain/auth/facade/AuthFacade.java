package com.example.moizaspringserver.domain.auth.facade;

import com.example.moizaspringserver.domain.auth.exception.PasswordMismatchException;
import com.example.moizaspringserver.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.exception.UserAlreadyExistsException;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthFacade {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void passwordMatch(User user, UserSignInRequest request) {
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

    }

    public void checkUserExistsByAccountId(String accountId) {
        if (userRepository.findByAccountId(accountId).isPresent()) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

}
