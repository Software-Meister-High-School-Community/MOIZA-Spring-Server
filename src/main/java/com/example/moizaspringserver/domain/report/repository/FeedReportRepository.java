package com.example.moizaspringserver.domain.report.repository;

import com.example.moizaspringserver.domain.report.entity.FeedReport;
import com.example.moizaspringserver.domain.report.entity.FeedReportId;
import org.springframework.data.repository.CrudRepository;

public interface FeedReportRepository extends CrudRepository<FeedReport, FeedReportId> {
}
