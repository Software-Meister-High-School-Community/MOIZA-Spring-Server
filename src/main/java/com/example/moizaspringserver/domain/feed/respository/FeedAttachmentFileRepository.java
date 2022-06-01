package com.example.moizaspringserver.domain.feed.respository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.feed.entity.FeedAttachmentFile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FeedAttachmentFileRepository extends CrudRepository<FeedAttachmentFile, Integer> {

    Optional<FeedAttachmentFile> findAllByFeed(Feed feed);
}
