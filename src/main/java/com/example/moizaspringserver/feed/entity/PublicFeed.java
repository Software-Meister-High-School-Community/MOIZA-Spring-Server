package com.example.moizaspringserver.feed.entity;

import com.example.moizaspringserver.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DynamicInsert
@Table(name = "tbl_public_feed")
public class PublicFeed extends BaseIdEntity {
    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 500)
    private String content;

    @NotNull
    private LocalDateTime updatedAt;

    @NotNull
    @ColumnDefault("0")
    private Integer likeCount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Builder
    public PublicFeed(String title, String content, LocalDateTime updatedAt, Integer likeCount, Feed feed) {
        this.title = title;
        this.content = content;
        this.updatedAt = updatedAt;
        this.likeCount = likeCount;
        this.feed = feed;
    }
}
