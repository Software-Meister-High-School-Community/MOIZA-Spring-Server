package com.example.moizaspringserver.domain.follow.repository;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.entity.FollowId;
import com.example.moizaspringserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends CrudRepository<Follow, FollowId> {
    @Query("select follow from Follow follow join fetch follow.targetUser")
    List<Follow> findAllByUserWithTarget(User user);

    List<Follow> findAllByTargetUser(User targetUser);
}
