package com.example.moizaspringserver.domain.comment.facade;


import com.example.moizaspringserver.domain.comment.entity.Comment;
import com.example.moizaspringserver.domain.comment.exception.CommentNotFoundException;
import com.example.moizaspringserver.domain.comment.repository.CommentRepository;
import com.example.moizaspringserver.domain.feed.entity.Feed;
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

}
