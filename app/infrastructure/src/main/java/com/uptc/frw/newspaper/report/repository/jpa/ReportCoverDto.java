package com.uptc.frw.newspaper.report.repository.jpa;

import com.uptc.frw.newspaper.domain.report.entity.ReportCover;
import com.uptc.frw.newspaper.jounalist.repository.jpa.JournalistDto;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Access(AccessType.FIELD)
@Table(name = "ReportCover")
public class ReportCoverDto {
    @Id
    @Column(name = "id_report_cover")
    public long id;
    @Column(name = "id_journalist", updatable = false, insertable = false)
    public long idJournalist;
    @Column(name = "id_report", updatable = false, insertable = false)
    public long idReport;
    @Column(name = "covered_date")
    public ZonedDateTime coveredDate;

    @ManyToOne
    @JoinColumn(name = "id_report")
    public ReportDto report;
    @ManyToOne
    @JoinColumn(name = "id_journalist")
    public JournalistDto journalist;

    public ReportCover toDomain() {
        return ReportCoverMapper.INSTANCE.toDomain(this, new CycleAvoidingMappingContext());
    }

    public static ReportCoverDto fromReportCover(final ReportCover reportCover) {
        return ReportCoverMapper.INSTANCE.toDto(reportCover, new CycleAvoidingMappingContext());
    }
}