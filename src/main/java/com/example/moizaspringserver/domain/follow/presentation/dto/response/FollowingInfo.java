package com.example.moizaspringserver.domain.follow.presentation.dto.response;

import com.example.moizaspringserver.domain.user.type.School;
import com.example.moizaspringserver.global.enums.UserType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FollowingInfo extends CommonFollowInfo {
    @Builder
    FollowingInfo(Integer userId, String name, String profileImageUrl, UserType userScope, School school) {
        super(userId, name, profileImageUrl, userScope, school);
    }
}
