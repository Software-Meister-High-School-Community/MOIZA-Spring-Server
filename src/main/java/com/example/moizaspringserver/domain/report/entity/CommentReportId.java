package com.example.moizaspringserver.domain.report.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class CommentReportId implements Serializable {

    private Integer comment;

    private Integer report;

    @Builder
    public CommentReportId(Integer comment, Integer report) {
        this.comment = comment;
        this.report = report;
    }

}
