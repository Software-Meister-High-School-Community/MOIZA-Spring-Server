package com.example.moizaspringserver.domain.notice.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class NoticeAttachmentFileException extends CustomException {

    public static final CustomException EXCEPTION =
            new NoticeAttachmentFileException();

    private NoticeAttachmentFileException() {
        super(ErrorCode.NOTICE_ATTACHMENT_FILE_NOT_FOUND);
    }
}
