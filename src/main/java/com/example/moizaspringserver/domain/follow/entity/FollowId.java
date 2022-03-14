package com.example.moizaspringserver.domain.follow.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class FollowId implements Serializable {

    private Integer user;

    private Integer targetUser;

    @Builder
    public FollowId(Integer user, Integer targetUser) {
        this.user = user;
        this.targetUser = targetUser;
    }
}

