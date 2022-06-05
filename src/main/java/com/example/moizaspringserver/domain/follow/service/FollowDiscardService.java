package com.example.moizaspringserver.domain.follow.service;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.exception.NoSuchFollowException;
import com.example.moizaspringserver.domain.follow.repository.FollowRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FollowDiscardService {
    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    @Transactional
    public void execute(int userIdToDiscard) {
        User queryUser = userFacade.queryCurrentUser();
        User targetUser = userFacade.queryUserById(userIdToDiscard);

        Follow relation = followRepository.findByUserAndTargetUser(queryUser, targetUser)
                .orElseThrow(() -> NoSuchFollowException.EXCEPTION);

        followRepository.delete(relation);
    }
}
