package com.example.moizaspringserver.domain.feed.presenstation;

import com.example.moizaspringserver.domain.feed.presenstation.dto.request.CreateFeedRequest;
import com.example.moizaspringserver.domain.feed.service.CreateFeedService;
import com.example.moizaspringserver.domain.feed.presenstation.dto.request.LocalFeedRequest;
import com.example.moizaspringserver.domain.feed.service.DeleteFeedService;
import com.example.moizaspringserver.domain.feed.service.UpdateLocalFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final DeleteFeedService deleteFeedService;
    private final CreateFeedService createFeedService;
    private final UpdateLocalFeedService updateLocalFeedService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Integer feedId) {
        deleteFeedService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.execute(request);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/temporaries/{feed-id}")
    public void updateLocalFeed(@RequestBody @Valid LocalFeedRequest request, @PathVariable("feed-id") Integer feedId) {
        updateLocalFeedService.execute(request, feedId);
    }

}
