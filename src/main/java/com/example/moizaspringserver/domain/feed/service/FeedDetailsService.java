package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.category.entity.FeedCategory;
import com.example.moizaspringserver.domain.category.exception.FeedCategoryNotFoundException;
import com.example.moizaspringserver.domain.category.repository.FeedCategoryRepository;
import com.example.moizaspringserver.domain.comment.entity.Comment;
import com.example.moizaspringserver.domain.comment.entity.CommentAttachmentFile;
import com.example.moizaspringserver.domain.comment.facade.CommentFacade;
import com.example.moizaspringserver.domain.comment.presentation.dto.response.ChildCommentListResponse;
import com.example.moizaspringserver.domain.comment.presentation.dto.response.ChildCommentListResponse.ChildCommentResponse;
import com.example.moizaspringserver.domain.comment.presentation.dto.response.CommentListResponse;
import com.example.moizaspringserver.domain.comment.presentation.dto.response.CommentListResponse.CommentResponse;
import com.example.moizaspringserver.domain.comment.repository.CommentAttachmentFileRepository;
import com.example.moizaspringserver.domain.comment.repository.CommentRepository;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.FeedAttachmentFile;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import com.example.moizaspringserver.domain.feed.facade.FeedFacade;
import com.example.moizaspringserver.domain.feed.presenstation.dto.response.FeedDetailsResponse;
import com.example.moizaspringserver.domain.feed.presenstation.dto.response.ImageUrlListResponse;
import com.example.moizaspringserver.domain.feed.presenstation.dto.response.ImageUrlListResponse.ImageUrlResponse;
import com.example.moizaspringserver.domain.feed.respository.FeedAttachmentFileRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import com.example.moizaspringserver.domain.user.presentation.dto.response.AuthorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FeedDetailsService {

    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final CommentFacade commentFacade;
    private final FeedAttachmentFileRepository feedAttachmentFileRepository;
    private final FeedCategoryRepository feedCategoryRepository;
    private final CommentRepository commentRepository;
    private final CommentAttachmentFileRepository commentAttachmentFileRepository;

    @Transactional(readOnly = true)
    public FeedDetailsResponse execute(Integer feedId) {

        Feed feed = feedFacade.getFeedById(feedId);

        User user = userFacade.queryCurrentUser();

        PublicFeed publicFeed = feedFacade.getPublicFeedByFeedId(feed);

        FeedCategory feedCategory = feedCategoryRepository.findByFeed(feed)
                .orElseThrow(() -> FeedCategoryNotFoundException.EXCEPTION);

        Boolean isMine = feedFacade.getMatchMyFeed(feedId, user);

        Boolean isUpdate = feedFacade.getIsUpdate(publicFeed);

        return FeedDetailsResponse.builder()
                .author(AuthorResponse.builder()
                        .userId(feed.getUser().getId())
                        .profileImageUrl(feed.getUser().getProfileImageUrl())
                        .schoolName(feed.getUser().getSchool())
                        .type(feed.getUser().getUserType())
                        .build())
                .title(publicFeed.getTitle())
                .content(publicFeed.getContent())
                .imageUrls(feedImageUrlResponseList(feed))
                .createdAt(publicFeed.getCreatedAt())
                .feedType(feed.getFeedType())
                .category(feedCategory.getCategory().getCategoryName())
                .isMine(isMine)
                .isUpdate(isUpdate)
                .likeCount(publicFeed.getLikeCount())
                .viewCount(publicFeed.getLikeCount())
                .comments(commentResponseList(feed))
                .build();
    }

    private ImageUrlListResponse feedImageUrlResponseList(Feed feed) {

        List<ImageUrlResponse> imageUrlLists = feedAttachmentFileRepository.findAllByFeed(feed)
                .stream()
                .map(this::getFeedImageUrl)
                .collect(Collectors.toList());

        return new ImageUrlListResponse(imageUrlLists);
    }

    private ImageUrlResponse getFeedImageUrl(FeedAttachmentFile feedAttachmentFile) {
        return new ImageUrlResponse(feedAttachmentFile.getAttachmentFileUrl());
    }

    private CommentListResponse commentResponseList(Feed feed) {
        List<CommentResponse> commentLists = commentRepository.findAllByFeed(feed)
                .stream()
                .map(this::commentBuilder)
                .collect(Collectors.toList());
        return new CommentListResponse(commentLists);
    }

    private CommentResponse commentBuilder(Comment comment) {
        Boolean isMine = commentFacade.getMatchMyComment(comment.getId(), comment.getUser());

        return CommentResponse.builder()
                .id(comment.getId())
                .author(authorBuilder(comment))
                .isMine(isMine)
                .createdAt(comment.getCreatedAt())
                .imageUrls(commentImageUrlResponseList(comment))
                .childComments(childCommentResponseList(comment))
                .build();
    }

    private ImageUrlListResponse commentImageUrlResponseList(Comment comment) {

        List<ImageUrlResponse> imageUrlLists = commentAttachmentFileRepository.findAllByComment(comment)
                .stream()
                .map(this::getCommentImageUrl)
                .collect(Collectors.toList());

        return new ImageUrlListResponse(imageUrlLists);
    }

    private ImageUrlResponse getCommentImageUrl(CommentAttachmentFile commentAttachmentFile) {
        return new ImageUrlResponse(commentAttachmentFile.getAttachmentFileUrl());
    }

    private ChildCommentListResponse childCommentResponseList(Comment comment) {
        List<ChildCommentResponse> childCommentLists = commentRepository.findAllByParentComment(comment)
                .stream()
                .map(this::childCommentBuilder)
                .collect(Collectors.toList());

        return new ChildCommentListResponse(childCommentLists);
    }

    private ChildCommentResponse childCommentBuilder(Comment comment) {
        return ChildCommentResponse.builder()
                .id(comment.getId())
                .patentCommentId(comment.getParentComment().getId())
                .author(authorBuilder(comment))
                .createdAt(comment.getCreatedAt())
                .content(comment.getContent())
                .build();
    }

    private AuthorResponse authorBuilder(Comment comment) {
        User commentParam = comment.getUser();
        return AuthorResponse.builder()
                .userId(commentParam.getId())
                .profileImageUrl(commentParam.getProfileImageUrl())
                .schoolName(commentParam.getSchool())
                .type(commentParam.getUserType())
                .build();
    }
}
