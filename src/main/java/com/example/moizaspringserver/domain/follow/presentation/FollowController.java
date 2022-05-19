package com.example.moizaspringserver.domain.follow.presentation;

import com.example.moizaspringserver.domain.follow.presentation.dto.response.GetAllFollowingResponse;
import com.example.moizaspringserver.domain.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {
    private final FollowService followService;

    @GetMapping("/following/{user-id}")
    public GetAllFollowingResponse getAllFollowing(@PathVariable("user-id") Integer userId) {
        return followService.getAllFollowing(userId);
    }
}
