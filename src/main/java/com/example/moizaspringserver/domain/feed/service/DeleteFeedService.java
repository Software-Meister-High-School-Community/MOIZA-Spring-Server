package com.example.moizaspringserver.domain.feed.service;

import com.example.moizaspringserver.domain.category.exception.FeedCategoryNotFoundException;
import com.example.moizaspringserver.domain.category.repository.FeedCategoryRepository;
import com.example.moizaspringserver.domain.comment.entity.Comment;
import com.example.moizaspringserver.domain.comment.facade.CommentFacade;
import com.example.moizaspringserver.domain.comment.repository.CommentRepository;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.exception.PublicFeedNotFoundException;
import com.example.moizaspringserver.domain.feed.facade.FeedFacade;
import com.example.moizaspringserver.domain.feed.respository.FeedRepository;
import com.example.moizaspringserver.domain.feed.respository.PublicFeedRepository;
import com.example.moizaspringserver.domain.like.exception.FeedLikeNotFoundException;
import com.example.moizaspringserver.domain.like.repository.FeedLikeRepository;
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
    private final CommentFacade commentFacade;
    private final FeedFacade feedFacade;
    private final FeedRepository feedRepository;
    private final PublicFeedRepository publicFeedRepository;
    private final FeedLikeRepository feedLikeRepository;
    private final FeedCategoryRepository feedCategoryRepository;
    private final CommentRepository commentRepository;
    private final FeedReportRepository feedReportRepository;

    @Transactional
    public void execute(Integer feedId) {
        User user = userFacade.queryCurrentUser();

        Feed feed = feedFacade.getFeedById(feedId);

        if (!user.equals(feed.getUser())) {
            throw InvalidRoleException.EXCEPTION;
        }

        publicFeedRepository.findByFeed(feed)
                .ifPresentOrElse(publicFeedRepository::delete, () -> {
                    throw PublicFeedNotFoundException.EXCEPTION;
                });

        feedLikeRepository.findAllByFeed(feed)
                .ifPresentOrElse(feedLikeRepository::delete, () -> {
                    throw FeedLikeNotFoundException.EXCEPTION;
                });

        feedCategoryRepository.findByFeed(feed)
                .ifPresentOrElse(feedCategoryRepository::delete, () -> {
                    throw FeedCategoryNotFoundException.EXCEPTION;
                });

        feedReportRepository.findAllByFeed(feed)
                .ifPresentOrElse(feedReportRepository::delete, () -> {
                    throw FeedReportNotFoundException.EXCEPTION;
                });

        feedFacade.deleteLocalFeedAllByComment(feed);

        feedRepository.delete(feed);

        Comment comment = commentFacade.getAllByFeed(feed);

        commentFacade.deleteAllByComment(comment);

        commentRepository.delete(comment);

    }
}
