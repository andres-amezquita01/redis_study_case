package com.uptc.frw.newspaper.domain.involvement;

import com.uptc.frw.newspaper.domain.involvementType.entity.InvolvementType;
import com.uptc.frw.newspaper.domain.report.entity.Report;

public record Involvement(
        long id,
        Report report,
        InvolvementType type
        //Talk
) {}
