package com.uptc.frw.newspaper.domain.report.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.*;

public record Report(
        Long id,
        String title,
        String content,
        ZonedDateTime occurredAtReport,
        List<ReportSubmission> reportSubmissions
) implements Serializable { }
