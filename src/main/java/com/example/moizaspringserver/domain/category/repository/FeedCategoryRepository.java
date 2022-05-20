package com.example.moizaspringserver.domain.category.repository;

import com.example.moizaspringserver.domain.category.entity.FeedCategory;
import com.example.moizaspringserver.domain.category.entity.FeedCategoryId;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FeedCategoryRepository extends CrudRepository<FeedCategory, FeedCategoryId> {

    Optional<FeedCategory> findByFeed(Feed feed);

}
