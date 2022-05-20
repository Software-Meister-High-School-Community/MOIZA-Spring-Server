package com.example.moizaspringserver.domain.follow.service;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.entity.FollowId;
import com.example.moizaspringserver.domain.follow.exception.FollowAlreadyExistsException;
import com.example.moizaspringserver.domain.follow.repository.FollowRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.exception.UserNotFoundException;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FollowEstablishService {
    private final UserFacade userFacade;
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Transactional
    public void addFollow(Integer userIdToFollow) {
        User currentUser = userFacade.queryCurrentUser();
        User targetUser = userRepository.findById(userIdToFollow)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        boolean isAlreadyExists = followRepository
                .findByUserAndTargetUser(currentUser, targetUser)
                .isPresent();
        if(isAlreadyExists) { throw FollowAlreadyExistsException.EXCEPTION; }

        FollowId followId = FollowId.builder()
                .user(currentUser.getId())
                .targetUser(targetUser.getId())
                .build();
        Follow follow = Follow.builder()
                .id(followId)
                .build();

        followRepository.save(follow);
    }
}
