package com.example.moizaspringserver.domain.feed.respository;

import com.example.moizaspringserver.domain.feed.entity.FeedLike;
import com.example.moizaspringserver.domain.feed.entity.FeedLikeId;
import org.springframework.data.repository.CrudRepository;

public interface FeedLikeRepository extends CrudRepository<FeedLike, FeedLikeId> {

}
