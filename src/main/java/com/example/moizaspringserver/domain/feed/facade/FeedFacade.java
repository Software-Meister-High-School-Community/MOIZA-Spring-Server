package com.example.moizaspringserver.domain.feed.facade;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.FeedAttachmentFile;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import com.example.moizaspringserver.domain.feed.exception.FeedAttachmentFileNotFoundException;
import com.example.moizaspringserver.domain.feed.exception.FeedNotFoundException;
import com.example.moizaspringserver.domain.feed.exception.PublicFeedNotFoundException;
import com.example.moizaspringserver.domain.feed.respository.FeedAttachmentFileRepository;
import com.example.moizaspringserver.domain.feed.respository.FeedRepository;
import com.example.moizaspringserver.domain.feed.respository.PublicFeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedFacade {

    private final FeedRepository feedRepository;
    private final PublicFeedRepository publicFeedRepository;
    private final FeedAttachmentFileRepository feedAttachmentFileRepository;

    public Feed getFeedById(Integer id) {
        return feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }

    public PublicFeed getPublicFeedByFeedId(Feed feed) {
        return publicFeedRepository.findByFeed(feed)
                .orElseThrow(() -> PublicFeedNotFoundException.EXCEPTION);
    }

    public FeedAttachmentFile getFeedAttachmentFileByFeedId(Feed feed) {
        return feedAttachmentFileRepository.findAllByFeed(feed)
                .orElseThrow(() -> FeedAttachmentFileNotFoundException.EXCEPTION);
    }
}
