package com.example.moizaspringserver.domain.auth.repository;

import com.example.moizaspringserver.domain.auth.entity.EmailCode;
import org.springframework.data.repository.CrudRepository;

public interface EmailCodeRepository extends CrudRepository<EmailCode, String> {

}
