package com.example.moizaspringserver.domain.feed.presenstation;

import com.example.moizaspringserver.domain.feed.service.DeleteFeedService;
import com.example.moizaspringserver.domain.feed.service.DeleteLocalFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final DeleteFeedService deleteFeedService;
    private final DeleteLocalFeedService deleteLocalFeedService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Integer feedId) {
        deleteFeedService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/temporaries/{feed-id}")
    public void deleteLocalFeed(@PathVariable("feed-id") Integer feedId) {
        deleteLocalFeedService.execute(feedId);
    }

}
