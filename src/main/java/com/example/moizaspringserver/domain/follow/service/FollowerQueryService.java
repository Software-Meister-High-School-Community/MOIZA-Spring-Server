package com.example.moizaspringserver.domain.follow.service;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.FollowerInfo;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.GetAllFollowerResponse;
import com.example.moizaspringserver.domain.follow.repository.FollowRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.exception.UserNotFoundException;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FollowerQueryService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public GetAllFollowerResponse getAllFollower(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        List<Follow> followerList = followRepository.findAllByTargetUserWithUser(user);
        List<FollowerInfo> followerInfoList = followerList.stream()
                .map(follow -> {
                    User follower = follow.getUser();
                    boolean isUserFollowingFollower = followRepository
                            .findByUserAndTargetUser(user, follower)
                            .isPresent();

                    return FollowerInfo.builder()
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
