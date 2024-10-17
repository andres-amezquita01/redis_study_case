package com.uptc.frw.newspaper.report.repository;

import com.uptc.frw.newspaper.domain.report.entity.Report;
import com.uptc.frw.newspaper.domain.report.repository.ReportRepository;
import com.uptc.frw.newspaper.report.repository.jpa.ReportDto;
import com.uptc.frw.newspaper.report.repository.jpa.ReportJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportImpl implements ReportRepository {

    private final ReportJpaRepository reportJpaRepository;

    public ReportImpl(ReportJpaRepository reportJpaRepository) {
        this.reportJpaRepository = reportJpaRepository;
    }

    @Override
    public Optional<Report> getReportById(Long reportId) {
        return reportJpaRepository.findById(reportId)
                .map(ReportDto::toDomain);
    }

    @Override
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
}
