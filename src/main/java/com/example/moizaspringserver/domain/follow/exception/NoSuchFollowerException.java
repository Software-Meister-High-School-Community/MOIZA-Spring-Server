package com.example.moizaspringserver.domain.follow.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class NoSuchFollowerException extends CustomException {
    public static final NoSuchFollowerException EXCEPTION = new NoSuchFollowerException();

    private NoSuchFollowerException() {
        super(ErrorCode.FOLLOW_NO_SUCH_FOLLOWER);
    }
}
