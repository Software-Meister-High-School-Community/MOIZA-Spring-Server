package com.example.moizaspringserver.domain.notice.service;

import com.example.moizaspringserver.domain.notice.entity.Notice;
import com.example.moizaspringserver.domain.notice.entity.NoticeAttachmentFile;
import com.example.moizaspringserver.domain.notice.exception.NoticeAttachmentFileException;
import com.example.moizaspringserver.domain.notice.exception.NoticeNotFoundException;
import com.example.moizaspringserver.domain.notice.repository.NoticeAttachmentFileRepository;
import com.example.moizaspringserver.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteNoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeAttachmentFileRepository noticeAttachmentFileRepository;

    @Transactional
    public void execute(Integer id) {

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        NoticeAttachmentFile noticeAttachmentFile = noticeAttachmentFileRepository.findAllByNotice(notice)
                .orElseThrow(() -> NoticeAttachmentFileException.EXCEPTION);


        noticeRepository.delete(notice);
        noticeAttachmentFileRepository.delete(noticeAttachmentFile);

    }
}
