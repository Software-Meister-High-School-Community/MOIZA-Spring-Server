package com.example.moizaspringserver.domain.notice.entity;

import com.example.moizaspringserver.domain.user.domain.User;
import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
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
@Table(name = "tbl_notice")
public class Notice extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 500)
    private String content;

    private LocalDateTime updatedAt;

    @NotNull
    @ColumnDefault(value = "false")
    private Boolean isPinned;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Notice(String title, String content, Boolean isPinned, User user) {
        this.title = title;
        this.content = content;
        this.isPinned = isPinned;
        this.user = user;
    }
}
