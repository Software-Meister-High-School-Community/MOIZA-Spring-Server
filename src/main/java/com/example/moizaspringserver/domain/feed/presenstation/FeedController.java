package com.example.moizaspringserver.domain.feed.presenstation;

import com.example.moizaspringserver.domain.feed.presenstation.dto.response.FeedDetailsResponse;
import com.example.moizaspringserver.domain.feed.service.DeleteFeedService;
import com.example.moizaspringserver.domain.feed.service.FeedDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final DeleteFeedService deleteFeedService;
    private final FeedDetailsService feedDetailsService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Integer feedId) {
        deleteFeedService.execute(feedId);
    }

    @GetMapping
    public FeedDetailsResponse feedList(@PathVariable("feed-id") Integer feedId) {
        return feedDetailsService.execute(feedId);
    }

}
