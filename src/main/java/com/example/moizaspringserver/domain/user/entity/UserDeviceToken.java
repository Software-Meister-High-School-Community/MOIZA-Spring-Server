package com.example.moizaspringserver.domain.user.entity;

import com.example.moizaspringserver.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user_device_token")
public class UserDeviceToken extends BaseIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Length(max = 64)
    private String appDeviceToken;

    @Length(max = 64)
    private String webDeviceToken;

    @Builder
    public UserDeviceToken(User user, String appDeviceToken, String webDeviceToken) {
        this.user = user;
        this.appDeviceToken = appDeviceToken;
        this.webDeviceToken = webDeviceToken;
    }

}
