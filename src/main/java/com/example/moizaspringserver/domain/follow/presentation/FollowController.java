package com.example.moizaspringserver.domain.follow.presentation;

import com.example.moizaspringserver.domain.follow.presentation.dto.response.GetAllFollowerResponse;
import com.example.moizaspringserver.domain.follow.presentation.dto.response.GetAllFollowingResponse;
import com.example.moizaspringserver.domain.follow.service.FollowEstablishService;
import com.example.moizaspringserver.domain.follow.service.FollowQueryService;
import com.example.moizaspringserver.domain.follow.service.FollowerDeleteService;
import com.example.moizaspringserver.domain.follow.service.FollowerQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {
    private final FollowQueryService followQueryService;

    private final FollowerQueryService followerQueryService;
    private final FollowEstablishService followEstablishService;
    private final FollowerDeleteService followerDeleteService;
    private final FollowDeleteService followDeleteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{user-id}")
    public void addFollow(@PathVariable("user-id") Integer userId) {
        followEstablishService.addFollow(userId);
    }

    @GetMapping("/following/{user-id}")
    public GetAllFollowingResponse getAllFollowing(@PathVariable("user-id") Integer userId) {
        return followQueryService.getAllFollowing(userId);
    }

    @GetMapping("/follower/{user-id}")
    public GetAllFollowerResponse getAllFollower(@PathVariable("user-id") Integer userId) {
        return followerQueryService.execute(userId);
    }
}
