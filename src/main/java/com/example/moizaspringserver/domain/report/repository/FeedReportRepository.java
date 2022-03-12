package com.example.moizaspringserver.domain.report.repository;

import com.example.moizaspringserver.domain.report.entity.FeedReport;
import com.example.moizaspringserver.domain.report.entity.FeedReportId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedReportRepository extends JpaRepository<FeedReport, FeedReportId> {
}
