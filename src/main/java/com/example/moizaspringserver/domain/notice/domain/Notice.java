package com.example.moizaspringserver.domain.notice.domain;

import com.example.moizaspringserver.domain.user.domain.User;
import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name= "tbl_notice")
public class Notice extends BaseTimeIdEntity {

    @NotNull
    @Length(max= 30)
    private String title;

    @NotNull
    @Length
    private String content;

    @NotNull
    private Boolean isUpdated = false;

    @NotNull
    private Boolean isPinned = false;

    @JoinColumn(name= "user_id")
    @ManyToOne(fetch= FetchType.LAZY)
    private User user;
}
