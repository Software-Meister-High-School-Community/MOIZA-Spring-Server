package com.example.moizaspringserver.domain.user.presentation.dto.response;

import com.example.moizaspringserver.domain.user.type.School;
import com.example.moizaspringserver.global.enums.UserType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private final Integer userId;
    private final String name;
    private final String profileImageUrl;
    private final UserType userType;
    private final School school;

}
