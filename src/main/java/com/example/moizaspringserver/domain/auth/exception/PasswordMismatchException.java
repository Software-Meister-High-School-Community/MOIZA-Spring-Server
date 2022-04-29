package com.example.moizaspringserver.domain.auth.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class PasswordMismatchException extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
