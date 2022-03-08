package com.example.moizaspringserver.domain.report.domain.repository;

import com.example.moizaspringserver.domain.report.domain.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Long> {
}
