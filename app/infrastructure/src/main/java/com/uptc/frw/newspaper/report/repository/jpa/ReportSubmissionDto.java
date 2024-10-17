package com.uptc.frw.newspaper.report.repository.jpa;

import com.uptc.frw.newspaper.agency.repository.jpa.AgencyDto;
import com.uptc.frw.newspaper.domain.report.entity.ReportSubmission;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Access(AccessType.FIELD)
@Table(name = "ReportSubmission")
public class ReportSubmissionDto {
    @Id
    @Column(name = "id_report_submission")
    public long id;
    @Column(name = "id_agency", insertable = false, updatable = false)
    public long idAgency;
    @Column(name = "id_report", insertable = false, updatable = false)
    public long idReport;
    @Column(name = "created_at_report_submission")
    public ZonedDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "id_agency")
    public AgencyDto agency;
    @ManyToOne
    @JoinColumn(name = "id_report")
    public ReportDto report;

    public ReportSubmissionDto() {
    }

    public ReportSubmission toDomain() {
        return ReportSubmissionMapper.INSTANCE.toDomain(this, new CycleAvoidingMappingContext());
    }

    public static ReportSubmissionDto fromReportSubmission(final ReportSubmission reportSubmission) {
        return ReportSubmissionMapper.INSTANCE.toDto(reportSubmission, new CycleAvoidingMappingContext());
    }

    public void setAgency(AgencyDto agency) {
        this.agency = agency;
    }

    public void setReport(ReportDto report) {
        this.report = report;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
