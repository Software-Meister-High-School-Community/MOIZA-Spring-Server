package com.example.moizaspringserver.domain.comment.facade;


import com.example.moizaspringserver.domain.comment.entity.Comment;
import com.example.moizaspringserver.domain.comment.exception.CommentAttachmentFileNotFoundException;
import com.example.moizaspringserver.domain.comment.exception.CommentNotFoundException;
import com.example.moizaspringserver.domain.comment.repository.CommentAttachmentFileRepository;
import com.example.moizaspringserver.domain.comment.repository.CommentRepository;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final CommentRepository commentRepository;
    private final CommentAttachmentFileRepository commentAttachmentFileRepository;

    public Comment getAllByFeed(Feed feed) {
        return commentRepository.findAllByFeed(feed)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

    public void deleteAllByComment(Comment comment) {
        commentAttachmentFileRepository.findAllByComment(comment)
                .ifPresentOrElse(commentAttachmentFileRepository::delete, () -> {
                    throw CommentAttachmentFileNotFoundException.EXCEPTION;
                });
    }
}
