package com.example.moizaspringserver.domain.report.entity;

import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user_report")
public class UserReport extends BaseTimeIdEntity {

    @EmbeddedId
    private UserReportId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    @Builder
    public UserReport(UserReportId id, User user, Report report) {
        this.id = id;
        this.user = user;
        this.report = report;
    }
}
