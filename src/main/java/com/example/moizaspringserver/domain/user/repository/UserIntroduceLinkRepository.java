package com.example.moizaspringserver.domain.user.repository;

import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.entity.UserIntroduceLink;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserIntroduceLinkRepository extends CrudRepository<UserIntroduceLink, Integer> {
    List<UserIntroduceLink> findAllByUser(User user);
}
