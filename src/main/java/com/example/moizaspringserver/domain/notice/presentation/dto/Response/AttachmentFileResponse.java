package com.example.moizaspringserver.domain.notice.presentation.dto.Response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttachmentFileResponse {
    private final String attachmentFileUrl;
}
