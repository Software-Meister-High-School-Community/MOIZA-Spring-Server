package com.example.moizaspringserver.domain.user.repository;

import com.example.moizaspringserver.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByAccountId(String accountId);
    Optional<User> findByEmail(String email);
}
