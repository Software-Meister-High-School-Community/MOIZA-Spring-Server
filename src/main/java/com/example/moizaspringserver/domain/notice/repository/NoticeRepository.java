package com.example.moizaspringserver.domain.notice.repository;

import com.example.moizaspringserver.domain.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
