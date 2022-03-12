package com.example.moizaspringserver.domain.feed.entity;

import com.example.moizaspringserver.domain.user.domain.User;
import com.example.moizaspringserver.domain.feed.type.FeedType;
import com.example.moizaspringserver.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed")
public class Feed extends BaseIdEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    private FeedType feedType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Feed(FeedType feedType, User user) {
        this.feedType = feedType;
        this.user = user;
    }
}
