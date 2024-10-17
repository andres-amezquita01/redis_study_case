package com.uptc.frw.newspaper.domain.involvement.entity;

import com.uptc.frw.newspaper.domain.involved.entity.Involved;
import com.uptc.frw.newspaper.domain.involvementType.entity.InvolvementType;
import com.uptc.frw.newspaper.domain.report.entity.Report;

public record Involvement(
    Long id,
    Report report,
    InvolvementType involvementType,
    Involved involved
//    Talk talk TODO...
) {}
