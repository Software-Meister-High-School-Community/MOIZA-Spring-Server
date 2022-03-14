package com.example.moizaspringserver.domain.report.repository;

import com.example.moizaspringserver.domain.report.entity.CommentReport;
import com.example.moizaspringserver.domain.report.entity.CommentReportId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentReportRepository extends JpaRepository<CommentReport, CommentReportId> {
}
