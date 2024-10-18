package com.uptc.frw.newspaper.agency.repository.jpa;

import com.uptc.frw.newspaper.report.repository.jpa.mappers.ReportSubmissionMapper;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.uptc.frw.newspaper.domain.agency.entity.Agency;

@Mapper( uses = ReportSubmissionMapper.class)
public interface AgencyMapper {

    AgencyMapper INSTANCE = Mappers.getMapper( AgencyMapper.class );

    AgencyDto toDto(Agency agency, @Context CycleAvoidingMappingContext context);

    Agency toDomain(AgencyDto agencyDto, @Context CycleAvoidingMappingContext context);
}
