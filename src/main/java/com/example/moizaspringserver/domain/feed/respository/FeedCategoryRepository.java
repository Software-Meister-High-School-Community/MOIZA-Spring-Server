package com.example.moizaspringserver.domain.feed.respository;

import com.example.moizaspringserver.domain.feed.entity.FeedCategory;
import com.example.moizaspringserver.domain.feed.entity.FeedCategoryId;
import org.springframework.data.repository.CrudRepository;

public interface FeedCategoryRepository extends CrudRepository<FeedCategory, FeedCategoryId> {

}
