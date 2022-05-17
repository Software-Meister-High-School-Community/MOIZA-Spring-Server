package com.example.moizaspringserver.domain.auth.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class EmailCodeRequestOverLimitException  extends CustomException {

	public static final CustomException EXCEPTION =
		new EmailCodeRequestOverLimitException();

	private EmailCodeRequestOverLimitException() {
		super(ErrorCode.EMAIL_CODE_REQUEST_OVER_LIMIT);
	}
}