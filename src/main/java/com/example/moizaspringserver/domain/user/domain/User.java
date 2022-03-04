package com.example.moizaspringserver.domain.user.domain;

import com.example.moizaspringserver.domain.user.domain.type.School;
import com.example.moizaspringserver.domain.user.domain.type.Sex;
import com.example.moizaspringserver.global.enums.UserType;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String accountId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @NotNull
    private String profileImageUrl;

    @Column(columnDefinition = "CHAR(7)", nullable = false)
    private Long profileBackgroundColor;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(length = 8, nullable = false)
    private Long birthDay;

    @Column(length = 200)
    private String introduce;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    private School school;

    @NotNull
    private LocalDateTime createAt;

    @Column(name = "app_device_token", length = 64, nullable = false)
    private String appDeviceToken;

    @Column(name = "web_device_token", length = 64, nullable = false)
    private String webDeviceToken;

    @Builder
    public User(String accountId, String password, String name, String profileImageUrl,
                Long profileBackgroundColor, Sex sex, Long birthDay, String introduce,
                UserType userType, School school, LocalDateTime createAt,
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
        this.createAt = createAt;
        this.appDeviceToken = appDeviceToken;
        this.webDeviceToken = webDeviceToken;
    }
}
