package com.uptc.frw.newspaper.domain.report.repository;

import com.uptc.frw.newspaper.domain.report.entity.ReportSubmission;

import java.util.List;
import java.util.Optional;

public interface ReportSubmissionRepository {

    Optional<ReportSubmission> getReportSubmissionById(final Long id);
    List<ReportSubmission> getAllReportSubmission();
    ReportSubmission insertReportSubmission(final Long agencyId, final Long reportId);
    Optional<ReportSubmission> updateReportSubmission(final Long agencyId, final Long reportId, final Long id);
    Optional<ReportSubmission> deleteReportSubmission(final Long id);

}
