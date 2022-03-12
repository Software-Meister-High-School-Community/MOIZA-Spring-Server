package com.example.moizaspringserver.domain.user.repository;

import com.example.moizaspringserver.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
