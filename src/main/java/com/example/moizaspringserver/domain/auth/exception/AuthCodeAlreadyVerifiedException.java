package com.example.moizaspringserver.domain.auth.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class AuthCodeAlreadyVerifiedException extends CustomException {

	public static final CustomException EXCEPTION =
		new AuthCodeAlreadyVerifiedException();

	private AuthCodeAlreadyVerifiedException() {
		super(ErrorCode.AUTH_CODE_ALREADY_VERIFIED);
	}
}
