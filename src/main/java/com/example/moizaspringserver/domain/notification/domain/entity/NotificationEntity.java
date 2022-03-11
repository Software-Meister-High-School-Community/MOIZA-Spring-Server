package com.example.moizaspringserver.domain.notification.domain.entity;

import com.example.moizaspringserver.domain.notification.domain.type.Type;
import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_notification")
public class NotificationEntity extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 500)
    private String content;

    @NotNull
    private Long data;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    @Builder
    public NotificationEntity(String title, String content, Long data, Type type) {
        this.title = title;
        this.content = content;
        this.data = data;
        this.type = type;
    }
}
