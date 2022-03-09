package com.example.moizaspringserver.domain.follow.domain.repository;

import com.example.moizaspringserver.domain.follow.domain.entity.Follow;
import org.springframework.data.repository.CrudRepository;

public interface FollowRepository extends CrudRepository<Follow, Long> {
}
