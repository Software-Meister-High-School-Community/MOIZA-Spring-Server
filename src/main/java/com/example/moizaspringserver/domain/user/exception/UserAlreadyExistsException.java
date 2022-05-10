package com.example.moizaspringserver.domain.user.exception;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends CustomException {

	public static final CustomException EXCEPTION =
		new UserAlreadyExistsException();

	private UserAlreadyExistsException() {
		super(ErrorCode.USER_ALREADY_EXISTS);
	}
}