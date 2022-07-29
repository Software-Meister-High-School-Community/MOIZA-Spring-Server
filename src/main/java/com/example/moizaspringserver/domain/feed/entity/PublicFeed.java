package com.example.moizaspringserver.domain.feed.entity;

import com.example.moizaspringserver.global.entity.BaseTimeEntity;
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
@DynamicInsert
@Entity
@Table(name = "tbl_public_feed")
public class PublicFeed extends BaseTimeEntity {

    @Id
    private Integer feedId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 500)
    private String content;

    private LocalDateTime updatedAt;

    @NotNull
    @ColumnDefault("0")
    private Integer likeCount;

    @NotNull
    @ColumnDefault("0")
    private Integer viewCount;
    public void addViewCounts(Integer views) {
        viewCount += views;
    }

    @Builder
    public PublicFeed(String title, String content, Integer likeCount, Feed feed) {
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
        this.feed = feed;
    }
}
