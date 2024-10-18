package com.uptc.frw.newspaper.report.repository.jpa.mappers;

import com.uptc.frw.newspaper.domain.report.entity.ReportSubmission;
import com.uptc.frw.newspaper.report.repository.jpa.dto.ReportSubmissionDto;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReportSubmissionMapper {
    ReportSubmissionMapper INSTANCE = Mappers.getMapper(ReportSubmissionMapper.class);

    ReportSubmission toDomain(ReportSubmissionDto dto, @Context CycleAvoidingMappingContext context);
    ReportSubmissionDto toDto(ReportSubmission domain, @Context CycleAvoidingMappingContext context);
}
