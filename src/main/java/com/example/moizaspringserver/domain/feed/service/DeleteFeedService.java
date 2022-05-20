package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.category.entity.FeedCategory;
import com.example.moizaspringserver.domain.category.exception.FeedCategoryNotFoundException;
import com.example.moizaspringserver.domain.category.repository.FeedCategoryRepository;
import com.example.moizaspringserver.domain.comment.entity.Comment;
import com.example.moizaspringserver.domain.comment.entity.CommentAttachmentFile;
import com.example.moizaspringserver.domain.comment.exception.CommentAttachmentFileNotFoundException;
import com.example.moizaspringserver.domain.comment.exception.CommentNotFoundException;
import com.example.moizaspringserver.domain.comment.repository.CommentAttachmentFileRepository;
import com.example.moizaspringserver.domain.comment.repository.CommentRepository;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.FeedAttachmentFile;
import com.example.moizaspringserver.domain.feed.entity.LocalFeed;
import com.example.moizaspringserver.domain.feed.entity.PublicFeed;
import com.example.moizaspringserver.domain.feed.exception.FeedAttachmentFileNotFoundException;
import com.example.moizaspringserver.domain.feed.exception.FeedNotFoundException;
import com.example.moizaspringserver.domain.feed.exception.LocalFeedNotFoundException;
import com.example.moizaspringserver.domain.feed.exception.PublicFeedNotFoundException;
import com.example.moizaspringserver.domain.feed.respository.FeedAttachmentFileRepository;
import com.example.moizaspringserver.domain.feed.respository.FeedRepository;
import com.example.moizaspringserver.domain.feed.respository.LocalFeedRepository;
import com.example.moizaspringserver.domain.feed.respository.PublicFeedRepository;
import com.example.moizaspringserver.domain.like.entity.FeedLike;
import com.example.moizaspringserver.domain.like.exception.FeedLikeNotFoundException;
import com.example.moizaspringserver.domain.like.repository.FeedLikeRepository;
import com.example.moizaspringserver.domain.report.entity.FeedReport;
import com.example.moizaspringserver.domain.report.exception.FeedReportNotFoundException;
import com.example.moizaspringserver.domain.report.repository.FeedReportRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import com.example.moizaspringserver.global.error.security.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;
    private final LocalFeedRepository localFeedRepository;
    private final PublicFeedRepository publicFeedRepository;
    private final FeedLikeRepository feedLikeRepository;
    private final FeedAttachmentFileRepository feedAttachmentFileRepository;
    private final FeedCategoryRepository feedCategoryRepository;
    private final CommentRepository commentRepository;
    private final CommentAttachmentFileRepository commentAttachmentFileRepository;
    private final FeedReportRepository feedReportRepository;


    @Transactional
    public void execute(Integer feedId) {
        User user = userFacade.queryCurrentUser();

        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);

        LocalFeed localFeed = localFeedRepository.findByFeed(feed)
                .orElseThrow(() -> LocalFeedNotFoundException.EXCEPTION);

        PublicFeed publicFeed = publicFeedRepository.findByFeed(feed)
                .orElseThrow(() -> PublicFeedNotFoundException.EXCEPTION);

        FeedLike feedLike = feedLikeRepository.findAllByFeed(feed)
                .orElseThrow(() -> FeedLikeNotFoundException.EXCEPTION);

        FeedAttachmentFile feedAttachmentFile = feedAttachmentFileRepository.findAllByFeed(feed)
                .orElseThrow(() -> FeedAttachmentFileNotFoundException.EXCEPTION);

        FeedCategory feedCategory = feedCategoryRepository.findByFeed(feed)
                .orElseThrow(() -> FeedCategoryNotFoundException.EXCEPTION);

        Comment comment = commentRepository.findAllByFeed(feed)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        CommentAttachmentFile commentAttachmentFile = commentAttachmentFileRepository.findAllByComment(comment)
                .orElseThrow(() -> CommentAttachmentFileNotFoundException.EXCEPTION);

        FeedReport feedReport = feedReportRepository.findAllByFeed(feed)
                .orElseThrow(() -> FeedReportNotFoundException.EXCEPTION);


        if (!user.equals(feed.getUser())) {
            throw InvalidRoleException.EXCEPTION;
        }

        feedRepository.delete(feed);
        localFeedRepository.delete(localFeed);
        publicFeedRepository.delete(publicFeed);
        feedLikeRepository.delete(feedLike);
        feedAttachmentFileRepository.delete(feedAttachmentFile);
        feedCategoryRepository.delete(feedCategory);
        commentRepository.delete(comment);
        commentAttachmentFileRepository.delete(commentAttachmentFile);
        feedReportRepository.delete(feedReport);

    }
}
