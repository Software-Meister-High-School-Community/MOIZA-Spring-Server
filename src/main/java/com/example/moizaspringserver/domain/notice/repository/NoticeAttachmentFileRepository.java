package com.example.moizaspringserver.domain.notice.repository;

import com.example.moizaspringserver.domain.notice.entity.Notice;
import com.example.moizaspringserver.domain.notice.entity.NoticeAttachmentFile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NoticeAttachmentFileRepository extends CrudRepository<NoticeAttachmentFile, Integer> {

    Optional<NoticeAttachmentFile> findAllByNotice(Notice notice);

}
