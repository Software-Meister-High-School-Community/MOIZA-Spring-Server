package com.example.moizaspringserver.domain.report.repository;

import com.example.moizaspringserver.domain.feed.entity.Feed;
import com.example.moizaspringserver.domain.report.entity.FeedReport;
import com.example.moizaspringserver.domain.report.entity.FeedReportId;
import com.example.moizaspringserver.domain.report.entity.Report;
import com.example.moizaspringserver.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedReportRepository extends JpaRepository<FeedReport, FeedReportId> {

    void deleteByFeed(Feed feed);

    Optional<FeedReport> findByFeedAndReportUser(Feed feed, User user);

}
