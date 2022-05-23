package com.example.moizaspringserver.domain.follow.presentation.dto.response;

import com.example.moizaspringserver.domain.user.type.School;
import com.example.moizaspringserver.global.enums.UserType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FollowerInfo extends CommonFollowInfo {
    private final boolean isFollow;

    @Builder
    public FollowerInfo(Integer userId, String name, String profileImageUrl, UserType userScope, School school, boolean isFollow) {
        super(userId, name, profileImageUrl, userScope, school);
        this.isFollow = isFollow;
    }
}
