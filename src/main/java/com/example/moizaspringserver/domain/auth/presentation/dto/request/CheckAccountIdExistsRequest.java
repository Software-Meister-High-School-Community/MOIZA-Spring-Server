package com.example.moizaspringserver.domain.auth.presentation.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckAccountIdExistsRequest {
	@NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	private String accountId;
}
