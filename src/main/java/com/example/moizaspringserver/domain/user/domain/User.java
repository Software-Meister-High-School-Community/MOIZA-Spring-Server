package com.example.moizaspringserver.domain.user.domain;

import com.example.moizaspringserver.domain.user.domain.type.School;
import com.example.moizaspringserver.domain.user.domain.type.Sex;
import com.example.moizaspringserver.global.entity.BaseTimeEntity;
import com.example.moizaspringserver.global.enums.UserType;
import com.example.moizaspringserver.infrastructure.s3.DefaultImage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(max = 50)
    private String accountId;

    @NotNull
    @Length(max = 64)
    private String password;

    @NotNull
    @Length(max = 10)
    private String name;

    @NotNull
    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    private String profileImageUrl;

    @NotNull
    @Length(max = 7)
    private String profileBackgroundColor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    @Length(max = 8)
    private Long birthDay;

    @NotNull
    @Length(max = 8)
    private String introduce;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private School school;

    @NotNull
    private LocalDateTime createdAt;

    @Length(max = 64)
    private String appDeviceToken;

    @Length(max = 64)
    private String webDeviceToken;

    @Builder
    public User(String accountId, String password, String name, String profileImageUrl,
                String profileBackgroundColor, Sex sex, Long birthDay, String introduce,
                UserType userType, School school, LocalDateTime createdAt,
                String appDeviceToken, String webDeviceToken) {

        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.profileBackgroundColor = profileBackgroundColor;
        this.sex = sex;
        this.birthDay = birthDay;
        this.introduce = introduce;
        this.userType = userType;
        this.school = school;
        this.createdAt = createdAt;
        this.appDeviceToken = appDeviceToken;
        this.webDeviceToken = webDeviceToken;
    }
}
