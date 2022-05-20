package com.example.moizaspringserver.domain.like.repository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.like.entity.FeedLike;
import com.example.moizaspringserver.domain.like.entity.FeedLikeId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FeedLikeRepository extends CrudRepository<FeedLike, FeedLikeId> {

    Optional<FeedLike> findAllByFeed(Feed feed);

}
