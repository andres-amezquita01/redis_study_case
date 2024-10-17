package com.uptc.frw.newspaper.application.reportCover;

import com.uptc.frw.newspaper.application.shared.BaseUseCases;
import com.uptc.frw.newspaper.domain.report.entity.ReportCover;
import com.uptc.frw.newspaper.domain.report.repository.ReportCoverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportCoverUseCases extends BaseUseCases<ReportCover> {
    private final ReportCoverRepository reportCoverRepository;

    public ReportCoverUseCases(ReportCoverRepository reportCoverRepository) {
        this.reportCoverRepository = reportCoverRepository;
    }

    @Override
    public ReportCover add(ReportCover input) {
        return reportCoverRepository.insertReportCover(input);
    }

    @Override
    public Optional<ReportCover> remove(Long entityId) {
        return reportCoverRepository.removeReportCover(entityId);
    }

    @Override
    public List<ReportCover> listAll() {
        return reportCoverRepository.getAllReportCovers();
    }

    @Override
    public Optional<ReportCover> get(Long entityId) {
        return reportCoverRepository.getReportCoverById(entityId);
    }

    @Override
    public Optional<ReportCover> update(ReportCover input, Long entityId) {
        return reportCoverRepository.updateReportCover(input,entityId);
    }
}
