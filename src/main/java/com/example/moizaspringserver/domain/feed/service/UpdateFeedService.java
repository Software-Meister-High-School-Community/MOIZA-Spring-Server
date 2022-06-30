package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.FeedAttachmentFile;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import com.example.moizaspringserver.domain.feed.facade.FeedFacade;
import com.example.moizaspringserver.domain.feed.presenstation.dto.request.UpdateFeedRequest;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import com.example.moizaspringserver.global.error.security.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final FeedFacade feedFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(UpdateFeedRequest request, Integer feedId) {

        User user = userFacade.queryCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);
        PublicFeed publicFeed = feedFacade.getPublicFeedByFeedId(feed);
        FeedAttachmentFile feedAttachmentFile = feedFacade.getFeedAttachmentFileByFeedId(feed);

        if (!user.equals(feed.getUser())) {
            throw InvalidRoleException.EXCEPTION;
        }
        // TODO PR#105 머지시 리팩토링

        publicFeed.updateFeedTitle(request.getTitle());
        publicFeed.updateFeedContent(request.getContent());

        // TODO 사진 올리는거 없어서 나중에 추가되면 변경
    }
}
