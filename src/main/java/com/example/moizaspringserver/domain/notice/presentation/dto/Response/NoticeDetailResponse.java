package com.example.moizaspringserver.domain.notice.presentation.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class NoticeDetailResponse {

    private final List<NoticeDetail> noticeDetailList;

    @Getter
    @Builder
    public static class NoticeDetail {
        private final String title;
        private final String content;
        private final LocalDateTime createdAt;
        private final Boolean isUpdate;
        private final List<NoticeAttachmentFileResponse> attachmentFileUrl;
    }

    @Getter
    @AllArgsConstructor
    public static class NoticeAttachmentFileResponse {
        private final String attachmentFileUrl;
    }
}
