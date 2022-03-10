package com.example.moizaspringserver.feed.domain.respository;

import com.example.moizaspringserver.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
