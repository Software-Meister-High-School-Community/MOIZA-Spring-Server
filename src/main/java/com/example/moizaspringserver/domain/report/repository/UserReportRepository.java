package com.example.moizaspringserver.domain.report.repository;

import com.example.moizaspringserver.domain.report.entity.UserReport;
import com.example.moizaspringserver.domain.report.entity.UserReportId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReportRepository extends JpaRepository<UserReport, UserReportId> {
}
