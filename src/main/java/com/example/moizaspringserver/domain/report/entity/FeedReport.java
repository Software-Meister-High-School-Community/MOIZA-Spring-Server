package com.example.moizaspringserver.domain.report.entity;

import com.example.moizaspringserver.global.entity.BaseTimeIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed_report")
public class FeedReport extends BaseTimeIdEntity {

    @EmbeddedId
    private FeedReportId id;

    @Builder
    public FeedReport(FeedReportId id) {
        this.id = id;
    }
}
