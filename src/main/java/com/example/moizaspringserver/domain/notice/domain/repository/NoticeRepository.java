package com.example.moizaspringserver.domain.notice.domain.repository;

import com.example.moizaspringserver.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
