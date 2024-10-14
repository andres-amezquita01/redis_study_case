package com.uptc.frw.newspaper.report.repository.jpa;

import jakarta.persistence.*;
import lombok.Data;

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
    public List<ReportSubmissionDto> reportSubmissions;
    @ManyToMany
    @JoinTable(
            name = "RelatedReport",
            joinColumns = @JoinColumn(name = "id_report"),
            inverseJoinColumns = @JoinColumn(name = "id_related_report")
    )
    public List<ReportDto> relatedFromReports;
    @ManyToMany(mappedBy = "relatedFromReports")
    public List<ReportDto> relatedToReports;
    @OneToMany(mappedBy = "report")
    public List<ReportCoverDto> coverts;
}
