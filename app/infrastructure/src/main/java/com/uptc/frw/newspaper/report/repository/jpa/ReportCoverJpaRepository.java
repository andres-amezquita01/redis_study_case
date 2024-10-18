package com.uptc.frw.newspaper.report.repository.jpa;

import com.uptc.frw.newspaper.report.repository.jpa.dto.ReportCoverDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportCoverJpaRepository extends JpaRepository<ReportCoverDto,Long> {
}
