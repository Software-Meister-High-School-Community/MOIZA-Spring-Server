package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.feed.entity.LocalFeed;
import com.example.moizaspringserver.domain.feed.exception.LocalFeedNotFoundException;
import com.example.moizaspringserver.domain.feed.respository.LocalFeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteLocalFeedService {

    private final LocalFeedRepository localFeedRepository;

    @Transactional
    public void execute(Integer feedId) {
        LocalFeed localFeed = localFeedRepository.findById(feedId)
                .orElseThrow(() -> LocalFeedNotFoundException.EXCEPTION);

        localFeedRepository.delete(localFeed);
    }

}
