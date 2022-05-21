package com.example.moizaspringserver.domain.user.repository;

import com.example.moizaspringserver.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByAccountId(String accountId);

    Optional<User> findByEmail(String email);

    Page<User> findAllByNameContaining(String name, Pageable pageable);
}
