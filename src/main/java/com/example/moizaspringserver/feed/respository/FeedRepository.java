package com.example.moizaspringserver.feed.respository;

import com.example.moizaspringserver.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
