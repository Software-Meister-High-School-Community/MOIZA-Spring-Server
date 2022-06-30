package com.example.moizaspringserver.domain.feed.presenstation.dto.request;

import com.example.moizaspringserver.domain.feed.type.FeedType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
public class UpdateFeedRequest {

    @NotBlank(message = "title은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String title;

    @NotNull(message = "content는 Null일 수 없습니다.")
    private String content;

    @NotNull(message = "feed_type은 Null일 수 없습니다.")
    private FeedType feedType;

    @NotNull(message = "image_urls은 Null일 수 없습니다.")
    private List<String> imageUrls;

}
