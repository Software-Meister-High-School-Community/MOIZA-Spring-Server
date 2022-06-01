package com.example.moizaspringserver.domain.report.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class FeedReportNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeedReportNotFoundException();

    private FeedReportNotFoundException() {
        super(ErrorCode.FEED_REPORT_NOT_FOUND);
    }
}
