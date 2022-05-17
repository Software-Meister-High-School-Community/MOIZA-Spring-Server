package com.example.moizaspringserver.domain.auth.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SendEmailCodeResponse {

	private final String email;
}
