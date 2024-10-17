package com.uptc.frw.newspaper.involved.repository.jpa;

import com.uptc.frw.newspaper.agency.repository.jpa.AgencyMapper;
import com.uptc.frw.newspaper.domain.involved.entity.Involved;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper( uses = InvolvementMapper.class )
@Mapper
public interface InvolvedMapper {

    InvolvedMapper INSTANCE = Mappers.getMapper(InvolvedMapper.class);

    InvolvedDto toDto(Involved entity, @Context CycleAvoidingMappingContext context);

    Involved toDomain(InvolvedDto involvedDto, @Context CycleAvoidingMappingContext context);

}
