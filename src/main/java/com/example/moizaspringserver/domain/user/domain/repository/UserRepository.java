package com.example.moizaspringserver.domain.user.domain.repository;

import com.example.moizaspringserver.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
