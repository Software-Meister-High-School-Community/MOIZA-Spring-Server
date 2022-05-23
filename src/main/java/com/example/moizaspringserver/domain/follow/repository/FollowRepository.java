package com.example.moizaspringserver.domain.follow.repository;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.entity.FollowId;
import com.example.moizaspringserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowRepository extends CrudRepository<Follow, FollowId> {
    @Query("select follow from Follow follow join fetch follow.targetUser where follow.user=:user")
    List<Follow> findAllByUserWithTarget(@Param("user") User user);

    @Query("select follow from Follow follow join fetch follow.user where follow.targetUser=:target")
    List<Follow> findAllByTargetUserWithUser(@Param("target")  User targetUser);
    Optional<Follow> findByUserAndTargetUser(User user, User targetUser);
}
