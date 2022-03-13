package com.example.moizaspringserver.domain.report.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserReportId implements Serializable {

    private Integer user;

    private Integer report;

    @Builder
    public UserReportId(Integer user, Integer report) {
        this.user = user;
        this.report = report;
    }
}
