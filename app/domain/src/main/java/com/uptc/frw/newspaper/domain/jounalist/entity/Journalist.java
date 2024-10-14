package com.uptc.frw.newspaper.domain.jounalist.entity;

import com.uptc.frw.newspaper.domain.report.entity.ReportCover;
import java.util.*;

public record Journalist(
        Long id,
        String name,
        String address,
        String phoneNumber,
        List<ReportCover> reportCovers
) { }
