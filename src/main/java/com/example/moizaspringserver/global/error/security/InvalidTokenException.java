package com.example.moizaspringserver.global.error.security;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class InvalidTokenException extends CustomException {
    private static ErrorCode errorCode = new ErrorCode(400, "Expired or wrong token served");

    public InvalidTokenException() {
        super(errorCode);
    }
}
