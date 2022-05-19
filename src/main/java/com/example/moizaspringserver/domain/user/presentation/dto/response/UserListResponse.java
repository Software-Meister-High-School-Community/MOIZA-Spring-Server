package com.example.moizaspringserver.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserListResponse {

    private final Integer totalPage;
    private final List<UserResponse> userList;

}
