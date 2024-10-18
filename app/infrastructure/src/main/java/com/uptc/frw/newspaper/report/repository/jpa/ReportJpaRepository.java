package com.uptc.frw.newspaper.report.repository.jpa;

import com.uptc.frw.newspaper.report.repository.jpa.dto.ReportDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportJpaRepository extends JpaRepository<ReportDto, Long> {
}
