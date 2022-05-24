package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.category.repository.FeedCategoryRepository;
import com.example.moizaspringserver.domain.comment.entity.Comment;
import com.example.moizaspringserver.domain.comment.facade.CommentFacade;
import com.example.moizaspringserver.domain.comment.repository.CommentAttachmentFileRepository;
import com.example.moizaspringserver.domain.comment.repository.CommentRepository;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.facade.FeedFacade;
import com.example.moizaspringserver.domain.feed.respository.FeedRepository;
import com.example.moizaspringserver.domain.feed.respository.LocalFeedRepository;
import com.example.moizaspringserver.domain.feed.respository.PublicFeedRepository;
import com.example.moizaspringserver.domain.like.repository.FeedLikeRepository;
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
    private final CommentFacade commentFacade;
    private final FeedFacade feedFacade;
    private final FeedRepository feedRepository;
    private final PublicFeedRepository publicFeedRepository;
    private final FeedLikeRepository feedLikeRepository;
    private final FeedCategoryRepository feedCategoryRepository;
    private final FeedReportRepository feedReportRepository;
    private final LocalFeedRepository localFeedRepository;
    private final CommentRepository commentRepository;
    private final CommentAttachmentFileRepository commentAttachmentFileRepository;

    @Transactional
    public void execute(Integer feedId) {
        User user = userFacade.queryCurrentUser();

        Feed feed = feedFacade.getFeedById(feedId);

        if (!user.equals(feed.getUser())) {
            throw InvalidRoleException.EXCEPTION;
        }

        publicFeedRepository.deleteByFeed(feed);

        feedLikeRepository.deleteByFeed(feed);

        feedCategoryRepository.deleteByFeed(feed);

        feedReportRepository.deleteByFeed(feed);

        localFeedRepository.deleteByFeed(feed);

        feedRepository.delete(feed);

        Comment comment = commentFacade.getAllByFeed(feed);

        commentAttachmentFileRepository.deleteByComment(comment);

        commentRepository.delete(comment);

    }
}
