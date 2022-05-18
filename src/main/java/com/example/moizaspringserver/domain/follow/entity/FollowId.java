package com.example.moizaspringserver.domain.follow.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@EqualsAndHashCode
public class FollowId implements Serializable {

    private Integer user;

    private Integer targetUser;

    @Builder
    public FollowId(Integer user, Integer targetUser) {
        this.user = user;
        this.targetUser = targetUser;
    }
}

