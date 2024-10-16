package com.uptc.frw.newspaper.domain.report.entity;
import com.uptc.frw.newspaper.domain.jounalist.entity.Journalist;

import java.util.Date;

public record ReportCover(
        Long id,
        Date covered_date
//        Journalist journalist,
//        Report report
) { }
