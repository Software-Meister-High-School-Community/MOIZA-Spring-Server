package com.example.moizaspringserver.domain.report.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@EqualsAndHashCode
public class CommentReportId implements Serializable {

    private Integer comment;

    private Integer report;

    @Builder
    public CommentReportId(Integer comment, Integer report) {
        this.comment = comment;
        this.report = report;
    }

}
