package com.example.moizaspringserver.domain.feed.presenstation;

import com.example.moizaspringserver.domain.feed.service.AddLikeService;
import com.example.moizaspringserver.domain.feed.service.DeleteFeedService;
import javax.persistence.criteria.CriteriaBuilder.In;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final DeleteFeedService deleteFeedService;
    private final AddLikeService addLikeService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Integer feedId) {
        deleteFeedService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/{feed-id}/like")
    public void like(@PathVariable("feed-id") Integer feedId) {
        addLikeService.execute(feedId);
    }

}
