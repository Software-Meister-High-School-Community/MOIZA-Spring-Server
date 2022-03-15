package com.example.moizaspringserver.domain.auth.repository;

import com.example.moizaspringserver.domain.auth.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {

}
