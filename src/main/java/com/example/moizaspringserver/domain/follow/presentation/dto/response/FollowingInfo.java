package com.example.moizaspringserver.domain.follow.presentation.dto.response;

import com.example.moizaspringserver.domain.user.type.School;
import com.example.moizaspringserver.global.enums.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowingInfo {
    @JsonProperty("user_id")
    private Integer userId;

    private String name;

    @JsonProperty("profile_image_url")
    private String profileImageUrl;

    @JsonProperty("user_scope")
    private UserType userScope;

    private School school;
}
