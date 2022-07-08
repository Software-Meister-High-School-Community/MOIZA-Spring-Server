package com.example.moizaspringserver.domain.feed.presenstation;

import com.example.moizaspringserver.domain.feed.presenstation.dto.request.LocalFeedRequest;
import com.example.moizaspringserver.domain.feed.service.DeleteFeedService;
import com.example.moizaspringserver.domain.feed.service.ReportFeedService;
import com.example.moizaspringserver.domain.feed.service.DeleteLocalFeedService;
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
    private final ReportFeedService reportFeedService;
    private final DeleteLocalFeedService deleteLocalFeedService;
    private final UpdateLocalFeedService updateLocalFeedService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Integer feedId) {
        deleteFeedService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public void reportFeed(@PathVariable("feed-id") Integer feedId) {
        reportFeedService.execute(feedId);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/temporaries/{feed-id}")
    public void deleteLocalFeed(@PathVariable("feed-id") Integer feedId) {
        deleteLocalFeedService.execute(feedId);
    }
  
    @PatchMapping("/temporaries/{feed-id}")
    public void updateLocalFeed(@RequestBody @Valid LocalFeedRequest request, @PathVariable("feed-id") Integer feedId) {
        updateLocalFeedService.execute(request, feedId);
    }

}
