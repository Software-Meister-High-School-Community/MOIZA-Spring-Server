package com.example.moizaspringserver.domain.user.repository;

import com.example.moizaspringserver.domain.user.entity.GraduateVerifyingFile;
import com.example.moizaspringserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GraduateVerifyingFileRepository extends JpaRepository<GraduateVerifyingFile, Integer> {
    Optional<GraduateVerifyingFile> findByUser(User user);
}
