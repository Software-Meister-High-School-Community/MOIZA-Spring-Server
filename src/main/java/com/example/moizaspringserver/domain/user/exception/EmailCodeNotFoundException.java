package com.example.moizaspringserver.domain.user.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class EmailCodeNotFoundException extends CustomException {

	public static final CustomException EXCEPTION =
		new EmailCodeNotFoundException();

	private EmailCodeNotFoundException() {
		super(ErrorCode.EMAIL_CODE_NOT_FOUND);
	}
}
