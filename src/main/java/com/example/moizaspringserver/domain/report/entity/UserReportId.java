package com.example.moizaspringserver.domain.report.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class UserReportId implements Serializable {

    private Integer user;

    private Integer report;

    @Builder
    public UserReportId(Integer user, Integer report) {
        this.user = user;
        this.report = report;
    }
}
