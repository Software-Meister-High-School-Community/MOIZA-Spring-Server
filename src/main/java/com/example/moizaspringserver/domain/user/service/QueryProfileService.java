package com.example.moizaspringserver.domain.user.service;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.respository.FeedRepository;
import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.repository.FollowRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.entity.UserIntroduceLink;
import com.example.moizaspringserver.domain.user.exception.UserNotFoundException;
import com.example.moizaspringserver.domain.user.presentation.dto.response.UserProfile;
import com.example.moizaspringserver.domain.user.repository.UserIntroduceLinkRepository;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryProfileService {
    private final UserRepository userRepository;

    private final FeedRepository feedRepository;

    private final UserIntroduceLinkRepository userIntroduceLinkRepository;

    private final FollowRepository followRepository;

    public UserProfile execute(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        List<Feed> feedList = feedRepository.findAllByUser(user);
        List<Follow> followers = followRepository.findAllByTargetUserWithUser(user);
        List<Follow> followings = followRepository.findAllByUserWithTarget(user);
        List<String> links = userIntroduceLinkRepository.findAllByUser(user)
                .stream().map(UserIntroduceLink::getLinkUrl)
                .collect(Collectors.toList());

        UserProfile response = UserProfile.builder()
                .name(user.getName())
                .school(user.getSchool().name())
                .userScope(user.getUserType().name().split("_")[1])
                .profileImageUrl(user.getProfileImageUrl())
                .profileBackgroundColor(user.getProfileBackgroundColor())
                .introduce(user.getIntroduce())
                .linkUrl(links)
                .feedCount(feedList.size())
                .followerCount(followers.size())
                .followingCount(followings.size())
                .build();

        return response;
    }
}
