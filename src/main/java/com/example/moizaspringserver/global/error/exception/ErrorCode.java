package com.example.moizaspringserver.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
        INVALID_TOKEN(401, "Expired or wrong token served"),
        NO_TOKEN_SERVED(400, "No token served")
    ;

    private final int status;
    private final String message;
}
