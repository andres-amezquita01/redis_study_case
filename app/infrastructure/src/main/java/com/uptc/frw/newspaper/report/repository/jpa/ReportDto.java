package com.uptc.frw.newspaper.report.repository.jpa;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name = "Report")
public class ReportDto {
    @Id
    @Column(name = "id_report")
    public long id;
    @Column(name = "title_report")
    public String title;
    @Column(name = "content_report")
    public String content;
    @Column(name = "ocurred_at_report")
    public ZonedDateTime occurredAtReport;

    @OneToMany(mappedBy = "report")
    private List<ReportSubmissionDto> reportSubmissions;
}
