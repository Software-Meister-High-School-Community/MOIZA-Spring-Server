package com.example.moizaspringserver.domain.feed.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class PublicFeedNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new PublicFeedNotFoundException();

    private PublicFeedNotFoundException() {
        super(ErrorCode.PUBLIC_FEED_NOT_FOUND);
    }
}
