package com.uptc.frw.newspaper.domain.report.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frw.newspaper.domain.agency.entity.Agency;

import java.io.Serializable;
import java.time.ZonedDateTime;

public record ReportSubmission(
       Long id,
       @JsonIgnore // This shouldn't be here.
       Agency agency,
       @JsonIgnore // This shouldn't be here.
       Report report,
       ZonedDateTime createdAt
) implements Serializable {
    public ReportSubmission removeAgency() {
        return new ReportSubmission(this.id, null, this.report, this.createdAt) ;
    }
}
