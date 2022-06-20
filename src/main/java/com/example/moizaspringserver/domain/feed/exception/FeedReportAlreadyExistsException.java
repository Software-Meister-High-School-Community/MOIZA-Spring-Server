package com.example.moizaspringserver.domain.feed.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class FeedReportAlreadyExistsException extends CustomException {

    public static final CustomException EXCEPTION = new FeedReportAlreadyExistsException();

    private FeedReportAlreadyExistsException() {
        super(ErrorCode.FEED_REPORT_ALREADY_EXISTS);
    }

}
