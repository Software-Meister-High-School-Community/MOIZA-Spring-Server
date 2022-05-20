package com.example.moizaspringserver.domain.feed.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class LocalFeedNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new LocalFeedNotFoundException();

    private LocalFeedNotFoundException() {
        super(ErrorCode.LOCAL_FEED_NOT_FOUND);
    }
}
