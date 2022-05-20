package com.example.moizaspringserver.domain.comment.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class CommentNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new CommentNotFoundException();

    private CommentNotFoundException() {
        super(ErrorCode.COMMENT_FOT_FOUND);
    }
}
