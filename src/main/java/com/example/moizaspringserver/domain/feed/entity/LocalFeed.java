package com.example.moizaspringserver.domain.feed.entity;

import com.example.moizaspringserver.global.entity.BaseTimeEntity;
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
@Table(name = "tbl_local_feed")
public class LocalFeed extends BaseTimeEntity {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @NotNull
    @Length(max = 30)
    private String title;

    @Length(max = 500)
    private String content;

    @Builder
    public LocalFeed(String title, String content, Feed feed) {
        this.title = title;
        this.content = content;
        this.feed = feed;
    }

}
