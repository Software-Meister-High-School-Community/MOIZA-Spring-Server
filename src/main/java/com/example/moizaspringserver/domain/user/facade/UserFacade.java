package com.example.moizaspringserver.domain.user.facade;

import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.exception.UserNotFoundException;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import com.example.moizaspringserver.global.error.security.CredentialsNotFoundException;
import com.example.moizaspringserver.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User queryCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!(principal instanceof AuthDetails)) {
            throw CredentialsNotFoundException.EXCEPTION;
        }

        return userRepository.findByAccountId(((AuthDetails) principal).getUsername())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
