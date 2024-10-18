package com.uptc.frw.newspaper.domain.talk.entity;

import com.uptc.frw.newspaper.domain.involvement.entity.Involvement;
import com.uptc.frw.newspaper.domain.report.entity.ReportCover;

public record Talk (
        Long id,
        String transcription,
        ReportCover reportCover,
        Involvement involvement
)
{ }
