package com.example.moizaspringserver.domain.auth.presentation.dto.request;

import com.example.moizaspringserver.domain.auth.type.Type;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckEmailAuthCodeRequest {

	@NotBlank(message = "email은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	private String email;

	@NotBlank(message = "authCode는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	private String authCode;

	@NotNull(message = "type은 Null을 허용하지 않습니다.")
	private Type type;
}
