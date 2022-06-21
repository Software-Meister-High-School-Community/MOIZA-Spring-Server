package com.example.moizaspringserver.domain.feed.repository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.LocalFeed;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocalFeedRepository extends CrudRepository<LocalFeed, Integer> {

    void deleteByFeed(Feed feed);

    Optional<LocalFeed> findByFeed(Feed feed);


}
