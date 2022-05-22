package com.example.moizaspringserver.domain.auth.presentation.dto.request;

import com.example.moizaspringserver.domain.auth.type.Type;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendEmailAuthCodeRequest {

	@NotNull(message = "type은 Null을 허용하지 않습니다.")
	private Type type;

	@NotBlank(message = "valie는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	private String value;
}
