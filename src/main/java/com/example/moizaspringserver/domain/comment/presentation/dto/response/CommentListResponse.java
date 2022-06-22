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
public class CommentListResponse {

    private final List<CommentResponse> commentLists;

    @Getter
    @Builder
    public static class CommentResponse {
        private final Integer id;
        private final AuthorResponse author;
        private final Boolean isMine;
        private final Boolean isPinned;
        private final LocalDateTime createdAt;
        private final ImageUrlListResponse imageUrls;
        private final ChildCommentListResponse childComments;
    }
}
