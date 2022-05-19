package com.example.moizaspringserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@NoArgsConstructor
public class UpdateMyInfoRequest {

    @NotBlank(message = "profile_image_url은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String profileImageUrl;

    @NotBlank(message = "profile_back_ground는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String profileBackgroundColor;

    private String introduce;

    private List<String> introduceLinkUrl;

}
