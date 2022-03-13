package com.example.moizaspringserver.domain.user.entity;

import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user_suspension")
public class UserSuspension extends BaseTimeIdEntity {

    @NotNull
    private LocalDateTime expiredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public UserSuspension(LocalDateTime expiredAt, User user) {
        this.expiredAt = expiredAt;
        this.user = user;
    }
}
