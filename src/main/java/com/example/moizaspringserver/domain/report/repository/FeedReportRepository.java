package com.example.moizaspringserver.domain.report.repository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.report.entity.FeedReport;
import com.example.moizaspringserver.domain.report.entity.FeedReportId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedReportRepository extends JpaRepository<FeedReport, FeedReportId> {

    Optional<FeedReport> findAllByFeed(Feed feed);
}
