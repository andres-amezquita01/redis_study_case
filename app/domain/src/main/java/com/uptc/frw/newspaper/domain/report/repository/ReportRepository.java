package com.uptc.frw.newspaper.domain.report.repository;

import com.uptc.frw.newspaper.domain.report.entity.Report;

import java.util.List;
import java.util.Optional;

public interface ReportRepository {

    public Optional<Report> getReportById(final Long reportId);
    public List<Report> getAllReports();
    public Report insertReport(final Report reportId);
    public Optional<Report> removeReport(final Long reportId);
    public Optional<Report> updateReport(final Report report, final Long reportId);

}
