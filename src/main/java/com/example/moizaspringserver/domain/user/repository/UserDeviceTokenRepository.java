package com.example.moizaspringserver.domain.user.repository;

import com.example.moizaspringserver.domain.user.entity.UserDeviceToken;
import org.springframework.data.repository.CrudRepository;

public interface UserDeviceTokenRepository extends CrudRepository<UserDeviceToken, Integer> {
}

