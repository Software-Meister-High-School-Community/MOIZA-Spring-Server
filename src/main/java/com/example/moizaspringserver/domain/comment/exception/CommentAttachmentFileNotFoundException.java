package com.example.moizaspringserver.domain.comment.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class CommentAttachmentFileNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new CommentAttachmentFileNotFoundException();

    private CommentAttachmentFileNotFoundException() {
        super(ErrorCode.COMMENT_ATTACHMENT_FILE_NOT_FOUND);
    }
}
