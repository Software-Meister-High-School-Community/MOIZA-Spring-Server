package com.example.moizaspringserver.domain.user.entity;

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
@Table(name = "tbl_user_introduce_link")
public class UserIntroduceLink extends BaseIdEntity {

    @NotNull
    @Length(max = 255)
    private String linkUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public UserIntroduceLink(String linkUrl, User user) {
        this.linkUrl = linkUrl;
        this.user = user;
    }

}
