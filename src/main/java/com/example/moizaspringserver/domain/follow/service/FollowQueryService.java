package com.example.moizaspringserver.domain.follow.service;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.FollowerAndFollowingInfo;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.GetAllFollowingResponse;
import com.example.moizaspringserver.domain.follow.repository.FollowRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowQueryService {
    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    @Transactional(readOnly = true)
    public GetAllFollowingResponse getAllFollowing(Integer userId) {
        User user = userFacade.queryUserById(userId);

        List<Follow> followings = followRepository.findAllByUserWithTarget(user);
        List<FollowerAndFollowingInfo> followingList = followings.stream().map(follow -> {
            User targetUser = follow.getTargetUser();
            boolean isFollowingFollowsMe = followRepository
                    .findByUserAndTargetUser(targetUser, user)
                    .isPresent();

            return FollowerAndFollowingInfo.builder()
                    .userId(targetUser.getId())
                    .name(targetUser.getName())
                    .profileImageUrl(targetUser.getProfileImageUrl())
                    .userScope(targetUser.getUserType())
                    .isFollow(isFollowingFollowsMe)
                    .build();
        }).collect(Collectors.toList());

        return new GetAllFollowingResponse(followingList);
    }

}
