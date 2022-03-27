package com.example.moizaspringserver.global.error.security;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class NoTokenServedException extends CustomException {

    private static ErrorCode errorCode = new ErrorCode(400, "No token served");

    public NoTokenServedException() {
        super(errorCode);
    }
}
