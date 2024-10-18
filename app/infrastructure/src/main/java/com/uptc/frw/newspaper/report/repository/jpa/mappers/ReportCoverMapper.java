package com.uptc.frw.newspaper.report.repository.jpa.mappers;

import com.uptc.frw.newspaper.domain.report.entity.ReportCover;
import com.uptc.frw.newspaper.report.repository.jpa.dto.ReportCoverDto;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {JournalistMapper.class, ReportMapper.class})
@Mapper()
public interface ReportCoverMapper {
    ReportCoverMapper INSTANCE = Mappers.getMapper(ReportCoverMapper.class);

    ReportCover toDomain(ReportCoverDto dto, @Context CycleAvoidingMappingContext context);
    ReportCoverDto toDto(ReportCover domain, @Context CycleAvoidingMappingContext context);
}
