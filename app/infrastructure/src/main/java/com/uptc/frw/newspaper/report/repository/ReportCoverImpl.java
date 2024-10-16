package com.uptc.frw.newspaper.report.repository;

import com.uptc.frw.newspaper.domain.report.entity.ReportCover;
import com.uptc.frw.newspaper.domain.report.repository.ReportCoverRepository;
import com.uptc.frw.newspaper.involvementType.repository.jpa.InvolvementTypeDTO;
import com.uptc.frw.newspaper.report.repository.jpa.ReportCoverDto;
import com.uptc.frw.newspaper.report.repository.jpa.ReportCoverJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportCoverImpl implements ReportCoverRepository {
    private ReportCoverJpaRepository reportCoverJpaRepository;

    public ReportCoverImpl(ReportCoverJpaRepository reportCoverJpaRepository) {
        this.reportCoverJpaRepository = reportCoverJpaRepository;
    }

    @Override
    public Optional<ReportCover> getReportCoverById(Long reportCoverId) {
        return reportCoverJpaRepository.findById(reportCoverId)
                .map(ReportCoverDto::toDomain);
    }

    @Override
    public List<ReportCover> getAllReportCovers() {
        return reportCoverJpaRepository.findAll().stream().map(ReportCoverDto::toDomain).toList();
    }

    @Override
    public ReportCover insertReportCover(ReportCover reportCover) {
        final ReportCoverDto reportCoverDto = ReportCoverDto.fromReportCover(reportCover);
        return reportCoverJpaRepository.save(reportCoverDto).toDomain();
    }

    @Override
    public Optional<ReportCover> removeReportCover(Long reportCoverId) {
        return getReportCoverById(reportCoverId).map(foundReportCover ->{
            reportCoverJpaRepository.deleteById(reportCoverId);
            return  foundReportCover;
        });
    }

    @Override
    public Optional<ReportCover> updateReportCover(ReportCover reportCover, Long reportCoverId) {
        final ReportCoverDto newReportCoverData = ReportCoverDto.fromReportCover(reportCover);
        return getReportCoverById(reportCoverId)
                .map(ReportCoverDto::fromReportCover)
                .map(reportCoverDtoToUpdate ->{
                   //map "covered at" and update it.
                    return reportCoverJpaRepository.save(reportCoverDtoToUpdate).toDomain();
                });
    }
}
