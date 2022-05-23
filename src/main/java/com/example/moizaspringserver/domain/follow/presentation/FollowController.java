package com.example.moizaspringserver.domain.follow.presentation;

import com.example.moizaspringserver.domain.follow.presentation.dto.response.GetAllFollowingResponse;
import com.example.moizaspringserver.domain.follow.service.FollowEstablishService;
import com.example.moizaspringserver.domain.follow.service.FollowQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {
    private final FollowQueryService followQueryService;
    private final FollowEstablishService followEstablishService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{user-id}")
    public void addFollow(@PathVariable("user-id") Integer userId) {
        followEstablishService.addFollow(userId);
    }

    @GetMapping("/following/{user-id}")
    public GetAllFollowingResponse getAllFollowing(@PathVariable("user-id") Integer userId) {
        return followQueryService.getAllFollowing(userId);
    }
}
