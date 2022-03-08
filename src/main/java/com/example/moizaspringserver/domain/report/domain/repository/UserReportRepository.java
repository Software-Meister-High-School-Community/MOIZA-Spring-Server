package com.example.moizaspringserver.domain.report.domain.repository;

import com.example.moizaspringserver.domain.report.domain.UserReport;
import com.example.moizaspringserver.domain.report.domain.embedded.UserReportId;
import org.springframework.data.repository.CrudRepository;

public interface UserReportRepository extends CrudRepository<UserReport, UserReportId> {
}
