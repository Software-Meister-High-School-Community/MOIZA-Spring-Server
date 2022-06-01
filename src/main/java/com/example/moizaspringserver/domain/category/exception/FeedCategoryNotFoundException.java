package com.example.moizaspringserver.domain.category.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class FeedCategoryNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeedCategoryNotFoundException();

    private FeedCategoryNotFoundException() {
        super(ErrorCode.FEED_CATEGORY_NOT_FOUND);
    }
}
