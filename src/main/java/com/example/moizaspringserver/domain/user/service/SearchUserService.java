package com.example.moizaspringserver.domain.user.service;

import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.presentation.dto.response.UserListResponse;
import com.example.moizaspringserver.domain.user.presentation.dto.response.UserResponse;
import com.example.moizaspringserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class SearchUserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserListResponse execute(String name, Pageable pageable) {
        Page<User> pagingUsers = userRepository.findAllByNameContaining(name, pageable);

        int totalPage = pagingUsers.getTotalPages();
        List<User> content = pagingUsers.getContent();

        List<UserResponse> response = content.stream()
                .map(user -> UserResponse.builder()
                        .userId(user.getId())
                        .name(user.getName())
                        .profileImageUrl(user.getProfileImageUrl())
                        .userType(user.getUserType())
                        .school(user.getSchool())
                        .build())
                .collect(Collectors.toList());

        return new UserListResponse(totalPage, response);
    }

}
