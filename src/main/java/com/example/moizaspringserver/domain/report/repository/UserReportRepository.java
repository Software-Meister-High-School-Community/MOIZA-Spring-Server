package com.example.moizaspringserver.domain.report.repository;

import com.example.moizaspringserver.domain.report.entity.UserReport;
import com.example.moizaspringserver.domain.report.entity.UserReportId;
import org.springframework.data.repository.CrudRepository;

public interface UserReportRepository extends CrudRepository<UserReport, UserReportId> {
}
