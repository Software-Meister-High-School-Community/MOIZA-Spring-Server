package com.example.moizaspringserver.domain.auth.repository;

import com.example.moizaspringserver.domain.auth.entity.EmailCode;
import com.example.moizaspringserver.domain.auth.type.Type;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface EmailCodeRepository extends CrudRepository<EmailCode, String> {

	Optional<EmailCode> findByEmailAndType(String email, Type type);
}
