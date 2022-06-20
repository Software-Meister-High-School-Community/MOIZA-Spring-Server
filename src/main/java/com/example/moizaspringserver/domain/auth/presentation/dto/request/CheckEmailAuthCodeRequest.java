package com.example.moizaspringserver.domain.auth.presentation.dto.request;

import com.example.moizaspringserver.domain.auth.type.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckEmailAuthCodeRequest {

	private String email;

	private String authCode;

	private Type type;
}
