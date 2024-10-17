package com.uptc.frw.newspaper.domain.report.repository;

import com.uptc.frw.newspaper.domain.report.entity.ReportCover;

import java.util.List;
import java.util.Optional;

public interface ReportCoverRepository {
    public Optional<ReportCover> getReportCoverById(final Long reportCoverId);
    public List<ReportCover> getAllReportCovers();
    public ReportCover insertReportCover(final ReportCover reportCover);
    public Optional<ReportCover> removeReportCover(final Long reportCoverId);
    public Optional<ReportCover> updateReportCover(final ReportCover reportCover, final Long reportCoverId );
}
