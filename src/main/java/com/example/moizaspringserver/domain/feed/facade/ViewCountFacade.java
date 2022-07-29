package com.example.moizaspringserver.domain.feed.facade;

import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import com.example.moizaspringserver.domain.feed.exception.FeedNotFoundException;
import com.example.moizaspringserver.domain.feed.properties.ViewCountProperties;
import com.example.moizaspringserver.domain.feed.respository.PublicFeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Component
public class ViewCountFacade {

    private final ViewCountProperties viewCountProperties;
    private final PublicFeedRepository publicFeedRepository;
    private final Map<Integer, Integer> viewCounts = new ConcurrentHashMap<Integer, Integer>();

    @Transactional(readOnly = true)
    public Integer getViewCountOf(Integer feedId) {
        return publicFeedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION)
                .getViewCount();
    }

    @Transactional
    public void flushViewCount(Integer feedId) {
        PublicFeed feed = publicFeedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        feed.addViewCounts(viewCounts.get(feedId));
        viewCounts.remove(feedId);
    }

    public void addViewCountOf(Integer feedId) {
        if(viewCounts.containsKey(feedId)) viewCounts.put(feedId, 0);

        viewCounts.put(feedId, viewCounts.get(feedId));

        if(viewCounts.get(feedId) >= viewCountProperties.getCacheMaximum())
            flushViewCount(feedId);
    }
}
