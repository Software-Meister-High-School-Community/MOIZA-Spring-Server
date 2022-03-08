package com.example.moizaspringserver.feed.domain.respository;

import com.example.moizaspringserver.feed.domain.Feed;
import org.springframework.data.repository.CrudRepository;

public interface FeedRepository extends CrudRepository<Feed, Long> {
}
