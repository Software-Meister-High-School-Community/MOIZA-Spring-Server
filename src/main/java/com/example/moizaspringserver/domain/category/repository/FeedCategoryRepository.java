package com.example.moizaspringserver.domain.category.repository;

import com.example.moizaspringserver.domain.category.entity.FeedCategory;
import com.example.moizaspringserver.domain.category.entity.FeedCategoryId;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FeedCategoryRepository extends CrudRepository<FeedCategory, FeedCategoryId> {

    void deleteByFeed(Feed feed);

    List<FeedCategory> findById_Feed(Integer feedId);
}
