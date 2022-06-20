package com.example.moizaspringserver.domain.feed.respository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicFeedRepository extends JpaRepository<PublicFeed, Integer> {

    void deleteByFeed(Feed feed);
    List<PublicFeed> findTop8ByCreatedAtBetweenOrderByLikeCountDesc(LocalDateTime start, LocalDateTime end);

}
