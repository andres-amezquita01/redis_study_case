package com.uptc.frw.newspaper.report.repository.jpa;

import com.uptc.frw.newspaper.agency.repository.jpa.AgencyDto;
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
}
