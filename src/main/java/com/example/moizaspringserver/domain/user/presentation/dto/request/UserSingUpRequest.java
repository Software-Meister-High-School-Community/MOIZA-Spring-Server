package com.example.moizaspringserver.domain.user.presentation.dto.request;

import com.example.moizaspringserver.domain.user.type.School;
import com.example.moizaspringserver.domain.user.type.Sex;
import com.example.moizaspringserver.global.enums.UserType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSingUpRequest {

	@NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	private String accountId;

	@NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	@Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;" +
		"<=>?@＼^_`{|}~]{8,30}$",
		message = "password는 소문자, 숫자, 특수문자가 포함되어야 합니다.")
	private String password;

	@Email(message = "올바른 email형식을 지켜주세요")
	@NotBlank(message = "email는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	private String email;

	@NotBlank(message = "name는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
	private String name;

	@NotNull(message = "birthdat는 Null을 허용하지 않습니다.")
	private Long birthday;

	@NotNull(message = "sex는 Null을 허용하지 않습니다.")
	private Sex sex;

	@NotNull(message = "userType는 Null을 허용하지 않습니다.")
	private UserType userType;

	@NotNull(message = "school는 Null을 허용하지 않습니다.")
	private School school;
}
