package com.example.moizaspringserver.domain.feed.respository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.LocalFeed;
import org.springframework.data.repository.CrudRepository;

public interface LocalFeedRepository extends CrudRepository<LocalFeed, Integer> {

    LocalFeed deleteByFeed(Feed feed);

}
