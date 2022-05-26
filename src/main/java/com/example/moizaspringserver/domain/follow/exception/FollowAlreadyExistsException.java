package com.example.moizaspringserver.domain.follow.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class FollowAlreadyExistsException extends CustomException {
    public static final FollowAlreadyExistsException EXCEPTION = new FollowAlreadyExistsException();

    private FollowAlreadyExistsException() {
        super(ErrorCode.FOLLOW_ALREADY_EXISTS);
    }
}
