package com.uptc.frw.newspaper.application.report;

import com.uptc.frw.newspaper.application.shared.BaseUseCases;
import com.uptc.frw.newspaper.domain.report.entity.ReportSubmission;
import com.uptc.frw.newspaper.domain.report.repository.ReportSubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportSubmissionUseCases extends BaseUseCases<ReportSubmission> {

    private final ReportSubmissionRepository reportSubmissionRepository;

    public ReportSubmissionUseCases(ReportSubmissionRepository reportSubmissionRepository) {
        this.reportSubmissionRepository = reportSubmissionRepository;
    }

    @Override
    public ReportSubmission add(ReportSubmission input) {
        return reportSubmissionRepository.insertReportSubmission(
                input.agency().id(), input.report().id());
    }

    @Override
    public Optional<ReportSubmission> remove(Long entityId) {
        return reportSubmissionRepository.deleteReportSubmission(entityId);
    }

    @Override
    public List<ReportSubmission> listAll() {
        return reportSubmissionRepository.getAllReportSubmission();
    }

    @Override
    public Optional<ReportSubmission> get(Long entityId) {
        return reportSubmissionRepository.getReportSubmissionById(entityId);
    }

    @Override
    public Optional<ReportSubmission> update(ReportSubmission input, Long entityId) {
        return reportSubmissionRepository.updateReportSubmission(
                input.id(), input.id(), entityId);
    }

    public ReportSubmission add(Long agencyId, Long reportId) {
        return reportSubmissionRepository.insertReportSubmission(agencyId, reportId);
    }

    public Optional<ReportSubmission> update(Long agencyId, Long reportId, Long entityId) {
        return reportSubmissionRepository.updateReportSubmission(
                agencyId, reportId, entityId);
    }
}
