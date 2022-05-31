package com.example.moizaspringserver.domain.user.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class FileAlreadyExistsException extends CustomException {

    public static final CustomException EXCEPTION = new FileAlreadyExistsException();

    private FileAlreadyExistsException() {
        super(ErrorCode.FILE_NOT_FOUND);
    }
}
