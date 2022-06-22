package com.example.moizaspringserver.domain.feed.respository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublicFeedRepository extends JpaRepository<PublicFeed, Integer> {

    void deleteByFeed(Feed feed);

    Optional<PublicFeed> findByFeed(Feed feed);

}
