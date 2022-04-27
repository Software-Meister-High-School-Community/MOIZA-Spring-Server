package com.example.moizaspringserver.global.error.security;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class InvalidTokenException extends CustomException {

    public static InvalidTokenException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
