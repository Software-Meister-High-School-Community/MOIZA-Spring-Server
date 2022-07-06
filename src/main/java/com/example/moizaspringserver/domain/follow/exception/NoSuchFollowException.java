package com.example.moizaspringserver.domain.follow.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class NoSuchFollowException extends CustomException {
    public static final NoSuchFollowException EXCEPTION = new NoSuchFollowException();

    private NoSuchFollowException() {
        super(ErrorCode.FOLLOW_NOT_FOUND);
    }
}
