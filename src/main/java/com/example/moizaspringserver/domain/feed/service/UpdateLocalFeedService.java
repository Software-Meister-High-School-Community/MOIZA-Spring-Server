package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.feed.entity.LocalFeed;
import com.example.moizaspringserver.domain.feed.exception.FeedNotFoundException;
import com.example.moizaspringserver.domain.feed.presenstation.dto.request.LocalFeedRequest;
import com.example.moizaspringserver.domain.feed.respository.LocalFeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateLocalFeedService {

    private final LocalFeedRepository localFeedRepository;

    @Transactional
    public void execute(LocalFeedRequest request, Integer feedId) {
        LocalFeed localFeed = localFeedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        localFeed.updateFeed(request.getTitle(), request.getContent());
    }

}
