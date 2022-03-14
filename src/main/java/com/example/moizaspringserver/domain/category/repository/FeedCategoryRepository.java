package com.example.moizaspringserver.domain.category.repository;

import com.example.moizaspringserver.domain.category.entity.FeedCategory;
import com.example.moizaspringserver.domain.category.entity.FeedCategoryId;
import org.springframework.data.repository.CrudRepository;

public interface FeedCategoryRepository extends CrudRepository<FeedCategory, FeedCategoryId> {

}
