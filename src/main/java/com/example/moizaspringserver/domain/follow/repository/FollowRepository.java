package com.example.moizaspringserver.domain.follow.repository;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.entity.FollowId;
import com.example.moizaspringserver.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends CrudRepository<Follow, FollowId> {
    List<Follow> findAllByUser(User user);
}
