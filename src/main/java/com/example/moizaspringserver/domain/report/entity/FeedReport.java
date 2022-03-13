package com.example.moizaspringserver.domain.report.entity;

import com.example.moizaspringserver.domain.feed.entity.Feed;
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
@Table(name = "tbl_feed_report")
public class FeedReport extends BaseTimeIdEntity {

    @EmbeddedId
    private FeedReportId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    @Builder
    public FeedReport(FeedReportId id, Feed feed, Report report) {
        this.id = id;
        this.feed = feed;
        this.report = report;
    }
}
