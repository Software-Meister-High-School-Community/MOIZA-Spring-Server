package com.example.moizaspringserver.domain.comment.repository;

import com.example.moizaspringserver.domain.comment.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
