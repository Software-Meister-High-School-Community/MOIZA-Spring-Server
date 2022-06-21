package com.example.moizaspringserver.domain.comment.presentation.dto.response;

import com.example.moizaspringserver.domain.feed.presenstation.dto.response.ImageUrlListResponse;
import com.example.moizaspringserver.domain.user.presentation.dto.response.AuthorResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ChildCommentListResponse {

    private final List<ChildCommentResponse> childCommentLists;

    @Getter
    @Builder
    public static class ChildCommentResponse {
        private final Integer id;
        private final Integer patentCommentId;
        private final AuthorResponse author;
        private final Boolean isMine;
        private final ImageUrlListResponse imageUrls;
        private final LocalDateTime createdAt;
        private final String content;
    }
}
