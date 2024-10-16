package com.uptc.frw.newspaper.report.repository.jpa;

import com.uptc.frw.newspaper.domain.report.entity.Report;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ReportSubmissionMapper.class, ReportCoverDto.class})
public interface ReportMapper {
    ReportMapper INSTANCE = Mappers.getMapper( ReportMapper.class );

    ReportDto toDto(Report report, @Context CycleAvoidingMappingContext context);

    Report toDomain(ReportDto reportDto, @Context CycleAvoidingMappingContext context);
}
