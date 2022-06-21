package com.example.moizaspringserver.domain.notice.service;

import com.example.moizaspringserver.domain.notice.entity.Notice;
import com.example.moizaspringserver.domain.notice.entity.NoticeAttachmentFile;
import com.example.moizaspringserver.domain.notice.exception.NoticeNotFoundException;
import com.example.moizaspringserver.domain.notice.presentation.dto.Response.NoticeDetailResponse.NoticeAttachmentFileResponse;
import com.example.moizaspringserver.domain.notice.presentation.dto.Response.NoticeDetailResponse.NoticeDetail;
import com.example.moizaspringserver.domain.notice.repository.NoticeAttachmentFileRepository;
import com.example.moizaspringserver.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryNoticeDetailService {

    private final NoticeRepository noticeRepository;
    private final NoticeAttachmentFileRepository noticeAttachmentFileRepository;

    @Transactional(readOnly = true)
    public NoticeDetail execute(Integer id) {

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        List<NoticeAttachmentFileResponse> attachmentFileList = noticeAttachmentFileRepository.findAllByNotice(notice)
                .stream()
                .map(this::getNoticeAttachmentFileList)
                .collect(Collectors.toList());

        return NoticeDetail.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt())
                .isUpdate(getIsUpdate(notice))
                .attachmentFileUrl(attachmentFileList)
                .build();

    }

    private Boolean getIsUpdate(Notice notice) {
        return notice.getUpdatedAt().isEqual(null);
    }

    private NoticeAttachmentFileResponse getNoticeAttachmentFileList(NoticeAttachmentFile noticeAttachmentFile) {
        return new NoticeAttachmentFileResponse(noticeAttachmentFile.getAttachmentFileUrl());
    }
}

