package com.example.moizaspringserver.domain.feed.facade;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.LocalFeed;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import com.example.moizaspringserver.domain.feed.exception.FeedNotFoundException;
import com.example.moizaspringserver.domain.feed.exception.LocalFeedNotFoundException;
import com.example.moizaspringserver.domain.feed.exception.PublicFeedNotFoundException;
import com.example.moizaspringserver.domain.feed.repository.FeedRepository;
import com.example.moizaspringserver.domain.feed.repository.LocalFeedRepository;
import com.example.moizaspringserver.domain.feed.repository.PublicFeedRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.global.error.security.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedFacade {

    private final FeedRepository feedRepository;
    private final LocalFeedRepository localFeedRepository;
    private final PublicFeedRepository publicFeedRepository;

    public Feed getFeedById(Integer id) {
        return feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }

    public LocalFeed getLocalFeedByFeedId(Feed feed) {
        return localFeedRepository.findByFeed(feed)
                .orElseThrow(() -> LocalFeedNotFoundException.EXCEPTION);
    }

    public PublicFeed getPublicFeedByFeedId(Feed feed) {
        return publicFeedRepository.findByFeed(feed)
                .orElseThrow(() -> PublicFeedNotFoundException.EXCEPTION);
    }

    public Boolean getMatchMyFeed(Integer id, User user) {
        if (!user.equals(getFeedById(id).getUser())) {
            throw InvalidRoleException.EXCEPTION;
        } else {
            return true;
        }
    }

    public Boolean getIsUpdate(PublicFeed publicFeed) {
        return publicFeed.getUpdatedAt().isEqual(null);
    }
}
