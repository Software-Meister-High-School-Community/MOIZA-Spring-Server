package com.example.moizaspringserver.domain.follow.presentation;

import com.example.moizaspringserver.domain.follow.presentation.dto.response.GetAllFollowingResponse;
import com.example.moizaspringserver.domain.follow.service.FollowEstablishService;
import com.example.moizaspringserver.domain.follow.service.FollowInquireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {
    private final FollowInquireService followInquireService;
    private final FollowEstablishService followEstablishService;

    @PostMapping("/{user-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void newFollow(@PathVariable("user-id") Integer userId) {
        followEstablishService.newFollow(userId);
    }

    @GetMapping("/following/{user-id}")
    public GetAllFollowingResponse getAllFollowing(@PathVariable("user-id") Integer userId) {
        return followInquireService.getAllFollowing(userId);
    }
}
