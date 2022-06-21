package com.example.moizaspringserver.domain.comment.repository;

import com.example.moizaspringserver.domain.comment.entity.Comment;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    Optional<Comment> findAllByFeed(Feed feed);

    Optional<Comment> findAllByParentComment(Comment comment);

    void deleteAllByFeed(Feed feed);

}
