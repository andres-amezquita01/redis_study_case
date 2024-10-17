package com.uptc.frw.newspaper.report.repository;

import com.uptc.frw.newspaper.agency.repository.jpa.AgencyDto;
import com.uptc.frw.newspaper.agency.repository.jpa.AgencyJpaRepository;
import com.uptc.frw.newspaper.domain.report.entity.ReportSubmission;
import com.uptc.frw.newspaper.domain.report.repository.ReportSubmissionRepository;
import com.uptc.frw.newspaper.report.repository.jpa.ReportDto;
import com.uptc.frw.newspaper.report.repository.jpa.ReportJpaRepository;
import com.uptc.frw.newspaper.report.repository.jpa.ReportSubmissionDto;
import com.uptc.frw.newspaper.report.repository.jpa.ReportSubmissionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReportSubmissionRepositoryImpl implements ReportSubmissionRepository {

    private final ReportSubmissionJpaRepository jpaRepository;

    @Autowired
    private ReportJpaRepository reportJpaRepository;

    @Autowired
    private AgencyJpaRepository agencyJpaRepository;

    public ReportSubmissionRepositoryImpl(ReportSubmissionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<ReportSubmission> getReportSubmissionById(Long id) {
        return jpaRepository.findById(id)
                .map(ReportSubmissionDto::toDomain);
    }

    @Override
    public List<ReportSubmission> getAllReportSubmission() {
        return jpaRepository.findAll()
                .stream()
                .map(ReportSubmissionDto::toDomain)
                .toList();
    }

    @Override
    public ReportSubmission insertReportSubmission(Long agencyId, Long reportId) {
        AgencyDto agency = agencyJpaRepository.findById(agencyId).orElse(null);
        ReportDto report = reportJpaRepository.findById(reportId).orElse(null);

        if (agency != null && report != null) {
            ReportSubmissionDto dtoSave = new ReportSubmissionDto();
            dtoSave.setReport(report);
            dtoSave.setAgency(agency);
            dtoSave.setCreatedAt(ZonedDateTime.now());

            return jpaRepository.save(dtoSave)
                    .toDomain();
        }

        throw new RuntimeException("Agency or Report not exist");
    }

    @Override
    public Optional<ReportSubmission> deleteReportSubmission(Long id) {
        return getReportSubmissionById(id).map(report -> {
            jpaRepository.deleteById(id);
            return report;
        });
    }

    @Override
    public Optional<ReportSubmission> updateReportSubmission(Long agencyId, Long reportId, Long id) {
        AgencyDto agency = agencyJpaRepository.findById(agencyId).orElse(null);
        ReportDto report = reportJpaRepository.findById(reportId).orElse(null);

        if (agency != null && report != null) {
            return getReportSubmissionById(id).map(ReportSubmissionDto::fromReportSubmission)
                    .map(reportSubToUpdate -> {
                        reportSubToUpdate.report = report;
                        reportSubToUpdate.agency = agency;
                        reportSubToUpdate.createdAt = ZonedDateTime.now();
                        return jpaRepository.save(reportSubToUpdate);
                    }).map(ReportSubmissionDto::toDomain);
        }

        throw new RuntimeException("Agency or Report not exist");
    }

}
