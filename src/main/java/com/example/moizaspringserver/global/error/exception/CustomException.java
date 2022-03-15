package com.example.moizaspringserver.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{

    private final ErrorCode errorCode;

}
