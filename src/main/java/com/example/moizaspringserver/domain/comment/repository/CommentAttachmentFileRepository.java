package com.example.moizaspringserver.domain.comment.repository;

import com.example.moizaspringserver.domain.comment.entity.Comment;
import com.example.moizaspringserver.domain.comment.entity.CommentAttachmentFile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommentAttachmentFileRepository extends CrudRepository<CommentAttachmentFile, Integer> {

    Optional<CommentAttachmentFile> findAllByComment(Comment comment);
}
