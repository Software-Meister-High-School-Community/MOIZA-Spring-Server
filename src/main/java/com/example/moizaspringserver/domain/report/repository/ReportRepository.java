package com.example.moizaspringserver.domain.report.repository;

import com.example.moizaspringserver.domain.report.entity.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Long> {
}
