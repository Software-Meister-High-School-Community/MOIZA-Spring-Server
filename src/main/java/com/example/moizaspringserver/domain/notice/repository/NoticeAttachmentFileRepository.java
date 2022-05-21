package com.example.moizaspringserver.domain.notice.repository;

import com.example.moizaspringserver.domain.notice.entity.NoticeAttachmentFile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeAttachmentFileRepository extends CrudRepository<NoticeAttachmentFile, Integer> {
    List<NoticeAttachmentFile> findAllById(Integer id);
}
