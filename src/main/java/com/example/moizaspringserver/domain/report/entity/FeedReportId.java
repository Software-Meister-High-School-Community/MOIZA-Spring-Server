package com.example.moizaspringserver.domain.report.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@EqualsAndHashCode
public class FeedReportId implements Serializable {

    private Integer feed;

    private Integer report;

    @Builder
    public FeedReportId(Integer feed, Integer report) {
        this.feed = feed;
        this.report = report;
    }
}
