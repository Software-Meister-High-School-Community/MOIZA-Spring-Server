package com.example.moizaspringserver.domain.feed.presenstation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class LocalFeedRequest {

    @NotBlank(message = "title은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String title;

    private String content;

}
