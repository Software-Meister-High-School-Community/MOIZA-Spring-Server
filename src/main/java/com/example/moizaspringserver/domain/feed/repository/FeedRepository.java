package com.example.moizaspringserver.domain.feed.repository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Integer> {
}
