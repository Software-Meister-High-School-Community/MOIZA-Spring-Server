package com.example.moizaspringserver.domain.auth.repository;

import com.example.moizaspringserver.domain.auth.entity.EmailCodeLimit;
import org.springframework.data.repository.CrudRepository;

public interface EmailCodeLimitRepository extends CrudRepository<EmailCodeLimit, String> {

}
