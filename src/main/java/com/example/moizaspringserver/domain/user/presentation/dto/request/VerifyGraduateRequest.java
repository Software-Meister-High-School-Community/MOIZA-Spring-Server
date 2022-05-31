package com.example.moizaspringserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class VerifyGraduateRequest {

    @NotBlank(message = "verifying_file_url은 null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String verifyingFileUrl;

}
