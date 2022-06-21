package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import com.example.moizaspringserver.domain.feed.presenstation.dto.request.CreateFeedRequest;
import com.example.moizaspringserver.domain.feed.respository.FeedAttachmentFileRepository;
import com.example.moizaspringserver.domain.feed.respository.PublicFeedRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final PublicFeedRepository publicFeedRepository;
    private final FeedAttachmentFileRepository feedAttachmentFileRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateFeedRequest request) {
        User user = userFacade.queryCurrentUser();

        Feed feed = Feed.builder()
                .feedType(request.getFeedType())
                .user(user)
                .build();

        PublicFeed publicFeed = PublicFeed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .feed(feed)
                .build();

        publicFeedRepository.save(publicFeed);
        // TODO 이미지 저장 로직
    }
}
