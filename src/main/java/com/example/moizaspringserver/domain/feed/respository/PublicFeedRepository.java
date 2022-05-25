package com.example.moizaspringserver.domain.feed.respository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicFeedRepository extends JpaRepository<PublicFeed, Integer> {

    void deleteByFeed(Feed feed);

}
