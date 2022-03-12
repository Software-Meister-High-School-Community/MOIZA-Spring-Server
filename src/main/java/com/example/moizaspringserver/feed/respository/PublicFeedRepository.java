package com.example.moizaspringserver.feed.respository;

import com.example.moizaspringserver.feed.entity.PublicFeed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicFeedRepository extends JpaRepository<PublicFeed, Long> {
}
