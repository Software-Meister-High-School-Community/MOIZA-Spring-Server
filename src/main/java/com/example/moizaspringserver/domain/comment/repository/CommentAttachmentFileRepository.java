package com.example.moizaspringserver.domain.comment.repository;

import com.example.moizaspringserver.domain.comment.entity.CommentAttachmentFile;
import com.example.moizaspringserver.domain.feed.entity.Feed;
import org.springframework.data.repository.CrudRepository;

public interface CommentAttachmentFileRepository extends CrudRepository<CommentAttachmentFile, Integer> {

    void deleteAllByComment_Feed(Feed feed);
}
