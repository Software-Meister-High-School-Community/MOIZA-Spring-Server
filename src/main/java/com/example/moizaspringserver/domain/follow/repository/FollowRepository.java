package com.example.moizaspringserver.domain.follow.repository;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.entity.FollowId;
import org.springframework.data.repository.CrudRepository;

public interface FollowRepository extends CrudRepository<Follow, FollowId> {
}
