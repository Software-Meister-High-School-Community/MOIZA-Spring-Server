package com.example.moizaspringserver.domain.notice.service;

import com.example.moizaspringserver.domain.notice.entity.Notice;
import com.example.moizaspringserver.domain.notice.facade.NoticeFacade;
import com.example.moizaspringserver.domain.notice.repository.NoticeAttachmentFileRepository;
import com.example.moizaspringserver.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteNoticeService {

    private final NoticeFacade noticeFacade;
    private final NoticeRepository noticeRepository;
    private final NoticeAttachmentFileRepository noticeAttachmentFileRepository;

    @Transactional
    public void execute(Integer id) {

        Notice notice = noticeFacade.getByNoticeId(id);

        noticeRepository.delete(notice);
        noticeAttachmentFileRepository.deleteByNotice(notice);

    }
}
