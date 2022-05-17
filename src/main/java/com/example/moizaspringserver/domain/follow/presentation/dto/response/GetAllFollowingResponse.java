package com.example.moizaspringserver.domain.follow.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetAllFollowingResponse {
    private final List<FollowingInfo> followingUserList;
}
