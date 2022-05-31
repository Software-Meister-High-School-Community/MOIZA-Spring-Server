package com.example.moizaspringserver.domain.feed.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class FeedAttachmentFileNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeedAttachmentFileNotFoundException();

    private FeedAttachmentFileNotFoundException() {
        super(ErrorCode.FEED_ATTACHMENT_FILE_NOT_FOUND);
    }
}
