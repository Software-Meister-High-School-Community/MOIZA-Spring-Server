package com.example.moizaspringserver.domain.like.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class FeedLikeNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeedLikeNotFoundException();

    private FeedLikeNotFoundException() {
        super(ErrorCode.FEED_LIKE_NOT_FOUND);
    }
}
