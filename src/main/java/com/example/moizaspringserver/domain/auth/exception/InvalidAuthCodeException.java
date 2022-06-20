package com.example.moizaspringserver.domain.auth.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class InvalidAuthCodeException extends CustomException {
	public static final CustomException EXCEPTION =
		new InvalidAuthCodeException();

	private InvalidAuthCodeException() {
		super(ErrorCode.INVALID_AUTH_CODE);
	}
}
