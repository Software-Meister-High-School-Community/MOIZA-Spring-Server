package com.example.moizaspringserver.domain.comment.facade;


import com.example.moizaspringserver.domain.comment.entity.Comment;
import com.example.moizaspringserver.domain.comment.exception.CommentNotFoundException;
import com.example.moizaspringserver.domain.comment.repository.CommentRepository;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.global.error.security.InvalidRoleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getAllByFeed(Feed feed) {
        return commentRepository.findAllByFeed(feed)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

    public Comment getCommentById(Integer id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

    public Boolean getMatchMyComment(Integer id, User user) {
        if (!user.equals(getCommentById(id).getUser())) {
            throw InvalidRoleException.EXCEPTION;
        } else {
            return true;
        }
    }

}
