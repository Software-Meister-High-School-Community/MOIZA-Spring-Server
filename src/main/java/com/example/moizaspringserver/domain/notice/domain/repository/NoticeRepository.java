package com.example.moizaspringserver.domain.notice.domain.repository;

import com.example.moizaspringserver.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
}
