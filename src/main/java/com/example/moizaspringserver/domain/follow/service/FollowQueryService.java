package com.example.moizaspringserver.domain.follow.service;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.CommonFollowInfo;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.FollowingInfo;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.GetAllFollowingResponse;
import com.example.moizaspringserver.domain.follow.repository.FollowRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.exception.UserNotFoundException;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowQueryService {
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    @Transactional(readOnly = true)
    public GetAllFollowingResponse getAllFollowing(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        List<Follow> followings = followRepository.findAllByUserWithTarget(user);
        List<FollowingInfo> followingList = followings.stream().map(follow -> {
            User targetUser = follow.getTargetUser();
            return FollowingInfo.builder()
                    .userId(targetUser.getId())
                    .name(targetUser.getName())
                    .profileImageUrl(targetUser.getProfileImageUrl())
                    .userScope(targetUser.getUserType())
                    .build();
        }).collect(Collectors.toList());

        return new GetAllFollowingResponse(followingList);
    }

}
