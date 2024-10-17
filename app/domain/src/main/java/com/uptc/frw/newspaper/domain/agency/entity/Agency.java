package com.uptc.frw.newspaper.domain.agency.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uptc.frw.newspaper.domain.report.entity.ReportSubmission;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.*;

public record Agency (
        Long id,
        String name,
        ZonedDateTime createdAt,
        List<ReportSubmission> reportSubmissions
) implements Serializable {}