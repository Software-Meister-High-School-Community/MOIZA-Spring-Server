package com.example.moizaspringserver.domain.follow.presentation.dto.response;

import com.example.moizaspringserver.domain.user.type.School;
import com.example.moizaspringserver.global.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class FollowInfo {
    private final Integer userId;

    private final String name;

    private final String profileImageUrl;

    private final UserType userScope;

    private final School school;

    private final boolean isFollow;
}
