package com.example.moizaspringserver.domain.follow.service;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.FollowInfo;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.GetAllFollowerResponse;
import com.example.moizaspringserver.domain.follow.repository.FollowRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FollowerQueryService {

    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    @Transactional(readOnly = true)
    public GetAllFollowerResponse execute(Integer userId) {
        User user = userFacade.queryUserById(userId);

        List<Follow> followerList = followRepository.findAllByTargetUserWithUser(user);
        List<FollowInfo> followerInfoList = followerList.stream()
                .map(follow -> {
                    User follower = follow.getUser();
                    boolean isUserFollowingFollower = followRepository
                            .findByUserAndTargetUser(user, follower)
                            .isPresent();

                    return FollowInfo.builder()
                            .userId(follower.getId())
                            .name(follower.getName())
                            .profileImageUrl(follower.getProfileImageUrl())
                            .school(follower.getSchool())
                            .userScope(follower.getUserType())
                            .isFollow(isUserFollowingFollower)
                            .build();
                })
                .collect(Collectors.toList());

        return new GetAllFollowerResponse(followerInfoList);
    }
}
