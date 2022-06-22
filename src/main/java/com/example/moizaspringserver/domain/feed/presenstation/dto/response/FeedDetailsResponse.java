package com.example.moizaspringserver.domain.feed.presenstation.dto.response;

import com.example.moizaspringserver.domain.comment.presentation.dto.response.CommentListResponse;
import com.example.moizaspringserver.domain.feed.type.FeedType;
import com.example.moizaspringserver.domain.user.presentation.dto.response.AuthorResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FeedDetailsResponse {

    private final AuthorResponse author;
    private final String title;
    private final String content;
    private final ImageUrlListResponse imageUrls;
    private final LocalDateTime createdAt;
    private final FeedType feedType;
    private final String category;
    private final Boolean isMine;
    private final Boolean isUpdate;
    private final Integer likeCount;
    private final Integer viewCount;
    private final CommentListResponse comments;

}
