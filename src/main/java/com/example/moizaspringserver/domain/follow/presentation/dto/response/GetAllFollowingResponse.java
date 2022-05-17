package com.example.moizaspringserver.domain.follow.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetAllFollowingResponse {
    @JsonProperty("following_user_list")
    private List<FollowingInfo> followingUserList;
}
