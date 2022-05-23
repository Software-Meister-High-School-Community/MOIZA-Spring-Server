package com.example.moizaspringserver.domain.follow.presentation.dto.response;

import com.example.moizaspringserver.domain.user.type.School;
import com.example.moizaspringserver.global.enums.UserType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommonFollowInfo {
    private final Integer userId;

    private final String name;

    private final String profileImageUrl;

    private final UserType userScope;

    private final School school;
}
