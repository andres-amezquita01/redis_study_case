package com.uptc.frw.newspaper.domain.report.entity;

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
