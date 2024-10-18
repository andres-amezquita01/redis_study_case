package com.uptc.frw.newspaper.application.report;

import com.uptc.frw.newspaper.application.shared.BaseUseCases;
import com.uptc.frw.newspaper.domain.report.entity.Report;
import com.uptc.frw.newspaper.domain.report.repository.ReportRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportUseCases extends BaseUseCases<Report> {

    private final ReportRepository reportRepository;

    public ReportUseCases(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report add(Report idReport) {
        return reportRepository.insertReport(idReport);
    }

    @Override
    public Optional<Report> remove(Long entityId) {
        return reportRepository.removeReport(entityId);
    }

    @Override
    public List<Report> listAll() {
        return reportRepository.getAllReports();
    }

    @Override
    public Optional<Report> get(Long entityId) {
        return reportRepository.getReportById(entityId);
    }

    @Override
    public Optional<Report> update(Report report, Long entityId) {
        return reportRepository.updateReport(report, entityId);
    }

    public void addRelated(Long entityId, Long entityRelatedId) {
        reportRepository.addRelatedReport(entityId, entityRelatedId);
    }

    public void removeRelated(Long entityId, Long entityRelatedId) {
        reportRepository.removeRelatedReport(entityId, entityRelatedId);
    }

    public List<Report> getRelated(Long entityId) {
        return reportRepository.getRelatedReports(entityId);
    }
}
