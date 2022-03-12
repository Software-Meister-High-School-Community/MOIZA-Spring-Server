package com.example.moizaspringserver.feed.respository;

import com.example.moizaspringserver.feed.entity.LocalFeed;
import org.springframework.data.repository.CrudRepository;

public interface LocalFeedRepository extends CrudRepository<LocalFeed, Long> {
}
