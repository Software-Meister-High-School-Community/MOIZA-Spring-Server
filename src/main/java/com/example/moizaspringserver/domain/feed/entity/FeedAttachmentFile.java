package com.example.moizaspringserver.domain.feed.entity;

import com.example.moizaspringserver.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed_attachment_file")
public class FeedAttachmentFile extends BaseIdEntity {

    @NotNull
    @Length(max = 255)
    private String attachmentFileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Builder
    public FeedAttachmentFile(String attachmentFileUrl, Feed feed) {
        this.attachmentFileUrl = attachmentFileUrl;
        this.feed = feed;
    }

}
