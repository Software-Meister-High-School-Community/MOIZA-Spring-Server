package com.example.moizaspringserver.domain.user.repository;

import com.example.moizaspringserver.domain.user.entity.GraduateVerifyingFile;
import com.example.moizaspringserver.domain.user.entity.GraduateVerifyingFileId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduateVerifyingFileRepository extends JpaRepository<GraduateVerifyingFile, GraduateVerifyingFileId> {
}
