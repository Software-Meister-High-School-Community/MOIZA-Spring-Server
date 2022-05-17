package com.example.moizaspringserver.domain.follow.presentation.dto.response;

import com.example.moizaspringserver.domain.user.type.School;
import com.example.moizaspringserver.global.enums.UserType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FollowingInfo {
    private Integer userId;

    private String name;

    private String profileImageUrl;

    private UserType userScope;

    private School school;
}
