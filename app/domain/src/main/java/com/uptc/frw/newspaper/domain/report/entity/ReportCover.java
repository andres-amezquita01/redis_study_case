package com.uptc.frw.newspaper.domain.report.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uptc.frw.newspaper.domain.jounalist.entity.Journalist;

import java.time.ZonedDateTime;
import java.util.Date;

public record ReportCover(
        Long id,
        ZonedDateTime coveredDate,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        Journalist journalist,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        Report report
) { }
