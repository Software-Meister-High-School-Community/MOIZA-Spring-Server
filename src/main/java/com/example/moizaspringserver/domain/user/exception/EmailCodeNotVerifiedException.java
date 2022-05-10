package com.example.moizaspringserver.domain.user.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class EmailCodeNotVerifiedException extends CustomException {

	public static final CustomException EXCEPTION =
		new EmailCodeNotVerifiedException();

	private EmailCodeNotVerifiedException() {
		super(ErrorCode.EMAIL_CODE_NOT_VERIFIED);
	}
}