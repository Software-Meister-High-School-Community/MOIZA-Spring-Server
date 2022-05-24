package com.example.moizaspringserver.domain.like.repository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.like.entity.FeedLike;
import com.example.moizaspringserver.domain.like.entity.FeedLikeId;
import org.springframework.data.repository.CrudRepository;


public interface FeedLikeRepository extends CrudRepository<FeedLike, FeedLikeId> {

    FeedLike deleteByFeed(Feed feed);

}
