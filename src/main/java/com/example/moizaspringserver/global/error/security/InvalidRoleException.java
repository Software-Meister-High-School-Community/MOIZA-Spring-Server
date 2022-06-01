package com.example.moizaspringserver.global.error.security;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class InvalidRoleException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidRoleException();

    private InvalidRoleException() {
        super(ErrorCode.INVALID_ROLE);
    }
}
