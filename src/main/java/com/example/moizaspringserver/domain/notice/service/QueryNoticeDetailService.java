package com.example.moizaspringserver.domain.notice.service;

import com.example.moizaspringserver.domain.notice.entity.Notice;
import com.example.moizaspringserver.domain.notice.exception.NoticeNotFoundException;
import com.example.moizaspringserver.domain.notice.presentation.dto.Response.AttachmentFileResponse;
import com.example.moizaspringserver.domain.notice.presentation.dto.Response.NoticeDetailResponse;
import com.example.moizaspringserver.domain.notice.repository.NoticeAttachmentFileRepository;
import com.example.moizaspringserver.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryNoticeDetailService {

    private final NoticeRepository noticeRepository;
    private final NoticeAttachmentFileRepository noticeAttachmentFileRepository;

    @Transactional(readOnly = true)
    public NoticeDetailResponse execute(Integer id) {

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        List<AttachmentFileResponse> attachmentFileList = noticeAttachmentFileRepository.findAllById(id)
                .stream()
                .map(noticeAttachmentFile -> AttachmentFileResponse.builder()
                        .attachmentFileUrl(noticeAttachmentFile.getAttachmentFileUrl())
                        .build())
                .collect(Collectors.toList());

        return NoticeDetailResponse.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt())
                .isUpdate(getIsUpdate(notice))
                .attachmentFileUrl(attachmentFileList)
                .build();

    }

    public Boolean getIsUpdate(Notice notice) {
        return notice.getUpdatedAt().equals(LocalDateTime.now());
    }
}

