package com.example.moizaspringserver.domain.user.entity;

import com.example.moizaspringserver.domain.user.type.School;
import com.example.moizaspringserver.domain.user.type.Sex;
import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
import com.example.moizaspringserver.global.enums.UserType;
import com.example.moizaspringserver.infrastructure.s3.DefaultImage;
import javax.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Entity
@Table(name = "tbl_user")
public class User extends BaseTimeIdEntity {

    @NotNull
    @Length(max = 64)
    @Column(unique = true)
    private String email;

    @NotNull
    @Length(max = 50)
    @Column(unique = true)
    private String accountId;

    @NotNull
    @Length(max = 60)
    private String password;

    @NotNull
    @Length(max = 10)
    private String name;

    @ColumnDefault(DefaultImage.USER_PROFILE_IMAGE)
    @Column(nullable = false)
    private String profileImageUrl;

    @Length(max = 7)
    @Column(nullable = false)
    @ColumnDefault("'NNNNNNN'")
    private String profileBackgroundColor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    private Long birthDay;

    @Length(max = 8)
    private String introduce;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private School school;

    @Builder
    public User(String email, String accountId, String password, String name,
        Sex sex, Long birthDay, String introduce, UserType userType, School school) {
        this.email = email;
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.introduce = introduce;
        this.userType = userType;
        this.school = school;
    }

}
