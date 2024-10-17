package com.uptc.frw.newspaper.involvement.jpa;

import com.uptc.frw.newspaper.domain.involvement.entity.Involvement;
import com.uptc.frw.newspaper.involvementType.repository.jpa.InvolvementTypeMapper;
import com.uptc.frw.newspaper.report.repository.jpa.ReportMapper;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper(uses = {ReportMapper.class, InvolvementMapper.class, InvolvementTypeMapper.class})
@Mapper()
public interface InvolvementMapper {
    InvolvementMapper INSTANCE = Mappers.getMapper(InvolvementMapper.class);
    InvolvementDto toDto(Involvement involvement, @Context CycleAvoidingMappingContext context);
    Involvement toDomain(InvolvementDto involvementDto, @Context CycleAvoidingMappingContext context);
}
