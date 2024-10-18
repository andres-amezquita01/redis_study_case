package com.uptc.frw.newspaper.report.repository.jpa;

import com.uptc.frw.newspaper.report.repository.jpa.dto.ReportSubmissionDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportSubmissionJpaRepository
        extends JpaRepository<ReportSubmissionDto, Long> {
}