package com.example.moizaspringserver.domain.user.repository;

import com.example.moizaspringserver.domain.user.entity.UserSuspension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSuspensionRepository extends JpaRepository<UserSuspension, Integer> {
}
