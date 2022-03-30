package com.example.moizaspringserver.global.error.security;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class NoTokenServedException extends CustomException {
    public NoTokenServedException() {
        super(ErrorCode.NO_TOKEN_SERVED);
    }
}
