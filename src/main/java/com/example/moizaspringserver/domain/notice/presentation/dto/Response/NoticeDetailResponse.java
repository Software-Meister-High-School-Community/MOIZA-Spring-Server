package com.example.moizaspringserver.domain.notice.presentation.dto.Response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class NoticeDetailResponse {
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final Boolean isUpdate;
    private final List<AttachmentFileResponse> attachmentFileUrl;
}
