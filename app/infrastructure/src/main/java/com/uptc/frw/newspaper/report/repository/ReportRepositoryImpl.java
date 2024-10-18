package com.uptc.frw.newspaper.report.repository;

import com.uptc.frw.newspaper.domain.report.entity.Report;
import com.uptc.frw.newspaper.domain.report.repository.ReportRepository;
import com.uptc.frw.newspaper.report.repository.jpa.dto.ReportDto;
import com.uptc.frw.newspaper.report.repository.jpa.ReportJpaRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportRepositoryImpl implements ReportRepository {

    private final ReportJpaRepository reportJpaRepository;

    public ReportRepositoryImpl(ReportJpaRepository reportJpaRepository) {
        this.reportJpaRepository = reportJpaRepository;
    }

    @Override
    @Cacheable(value = "report", key = "#reportId")
    public Optional<Report> getReportById(Long reportId) {
        return reportJpaRepository.findById(reportId)
                .map(ReportDto::toDomain);
    }

    @Override
    @Cacheable(value = "reports")
    public List<Report> getAllReports() {
        return reportJpaRepository.findAll()
                .stream()
                .map(ReportDto::toDomain)
                .toList();
    }

    @Override
    public Report insertReport(Report report) {
        final var reportToSave = ReportDto.fromReport(report);
        return reportJpaRepository.save(reportToSave)
                .toDomain();
    }

    @Override
    public Optional<Report> removeReport(Long reportId) {
        return getReportById(reportId).map(report -> {
            reportJpaRepository.deleteById(reportId);
            return report;
        });
    }

    @Override
    public Optional<Report> updateReport(Report report, Long reportId) {
        final var newReportData = ReportDto.fromReport(report);
        return getReportById(reportId)
                .map(ReportDto::fromReport)
                .map(reportToUpdate -> {
                    reportToUpdate.title = newReportData.title;
                    reportToUpdate.content = newReportData.content;
                    reportToUpdate.occurredAtReport = newReportData.occurredAtReport;
                    return reportJpaRepository.save(reportToUpdate);
                }).map(ReportDto::toDomain);
    }

    @Override
    public void addRelatedReport(Long reportId, Long relatedReportId) {
        ReportDto report = reportJpaRepository.findById(reportId).orElseThrow();
        ReportDto relatedReport = reportJpaRepository.findById(relatedReportId).orElseThrow();

        report.getRelatedFromReports().add(relatedReport);

        reportJpaRepository.save(report);
    }

    @Override
    public void removeRelatedReport(Long reportId, Long relatedReportId) {
        ReportDto report = reportJpaRepository.findById(reportId).orElseThrow();
        ReportDto relatedReport = reportJpaRepository.findById(relatedReportId).orElseThrow();

        report.getRelatedFromReports().remove(relatedReport);

        reportJpaRepository.save(report);
    }

    @Override
    public List<Report> getRelatedReports(Long reportId) {
        ReportDto report = reportJpaRepository.findById(reportId).orElseThrow();
        return report.getRelatedFromReports()
                .stream()
                .map(ReportDto::toDomain)
                .toList();
    }
}
