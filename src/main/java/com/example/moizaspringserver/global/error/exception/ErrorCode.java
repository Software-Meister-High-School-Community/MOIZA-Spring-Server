package com.example.moizaspringserver.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    EXPIRED_TOKEN(401, "Expired Token"),
    INVALID_TOKEN(401, "Invalid Token"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),
    CREDENTIALS_NOT_FOUND(404, "Credentials Not Found"),

    USER_NOT_FOUND(404, "User Not Found"),
    USER_ALREADY_EXISTS(409, "User Already Exists"),

    PASSWORD_MISMATCH(401, "Password Mismatch"),

    EMAIL_CODE_NOT_FOUND(404, "Email Code Not Found"),
    EMAIL_CODE_NOT_VERIFIED(401, "Email Code Not Verified");


    private final int status;
    private final String message;
}
