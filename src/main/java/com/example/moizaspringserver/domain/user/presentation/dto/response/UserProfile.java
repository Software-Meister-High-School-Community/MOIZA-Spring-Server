package com.example.moizaspringserver.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class UserProfile {
    private String name;

    private String school;

    private String userScope;

    private String profileImageUrl;

    private String profileBackgroundColor;

    private String introduce;

    private List<String> linkUrl;

    private Integer feedCount;

    private Integer followerCount;

    private Integer followingCount;
}
