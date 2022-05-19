package com.example.moizaspringserver.domain.user.service;

import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.entity.UserIntroduceLink;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import com.example.moizaspringserver.domain.user.presentation.dto.request.UpdateMyInfoRequest;
import com.example.moizaspringserver.domain.user.repository.UserIntroduceLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UpdateMyInfoService {

    private final UserFacade userFacade;
    private final UserIntroduceLinkRepository userIntroduceLinkRepository;

    @Transactional
    public void execute(UpdateMyInfoRequest request) {
        User user = userFacade.queryCurrentUser();

        user.updateInfo(
                request.getProfileImageUrl(),
                request.getProfileBackgroundColor(),
                request.getIntroduce()
        );

        List<UserIntroduceLink> links = request.getIntroduceLinkUrl()
                .stream()
                .map(link -> UserIntroduceLink.builder()
                        .user(user)
                        .linkUrl(link)
                        .build())
                .collect(Collectors.toList());

        userIntroduceLinkRepository.saveAll(links);
    }

}
