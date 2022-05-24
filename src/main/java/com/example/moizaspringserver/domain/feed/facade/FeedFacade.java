package com.example.moizaspringserver.domain.feed.facade;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.exception.FeedNotFoundException;
import com.example.moizaspringserver.domain.feed.exception.LocalFeedNotFoundException;
import com.example.moizaspringserver.domain.feed.respository.FeedRepository;
import com.example.moizaspringserver.domain.feed.respository.LocalFeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedFacade {

    private final FeedRepository feedRepository;
    private final LocalFeedRepository localFeedRepository;

    public Feed getFeedById(Integer id) {
        return feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }

    public void deleteLocalFeedAllByComment(Feed feed) {
        localFeedRepository.findByFeed(feed)
                .ifPresentOrElse(localFeedRepository::delete, () -> {
                    throw LocalFeedNotFoundException.EXCEPTION;
                });
    }

}
