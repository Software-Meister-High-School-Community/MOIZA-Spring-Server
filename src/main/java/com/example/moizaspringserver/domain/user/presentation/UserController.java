package com.example.moizaspringserver.domain.user.presentation;

import com.example.moizaspringserver.domain.user.presentation.dto.request.UpdateMyInfoRequest;
import com.example.moizaspringserver.domain.user.presentation.dto.request.UserSingUpRequest;
import com.example.moizaspringserver.domain.user.presentation.dto.request.VerifyGraduateRequest;
import com.example.moizaspringserver.domain.user.presentation.dto.response.UserListResponse;
import com.example.moizaspringserver.domain.user.presentation.dto.response.UserProfile;
import com.example.moizaspringserver.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private static final Integer PAGE_SIZE = 6;

    private final UserSingUpService userSingUpService;
    private final UpdateMyInfoService updateMyInfoService;
    private final SearchUserService searchUserService;
    private final VerifyGraduateService verifyGraduateService;

    private final QueryProfileService queryProfileService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void singUp(@RequestBody @Valid UserSingUpRequest userSingUpRequest) {
        userSingUpService.execute(userSingUpRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping
    public void updateMyInfo(@RequestBody @Valid UpdateMyInfoRequest request) {
        updateMyInfoService.execute(request);
    }

    @GetMapping("/searching")
    public UserListResponse searchUser(@RequestParam String name,
                                       @RequestParam Integer page) {
        PageRequest pageRequest = PageRequest.of(page, PAGE_SIZE);
        return searchUserService.execute(name, pageRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/graduate-verifications")
    public void verifyGraduate(@RequestBody @Valid VerifyGraduateRequest request) {
        verifyGraduateService.execute(request);
    }

    @GetMapping("/{user-id}")
    public UserProfile getUserProfile(@PathVariable("user-id") Integer userId) {
        return queryProfileService.execute(userId);
    }
}
