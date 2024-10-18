package com.uptc.frw.newspaper.involvementType.repository.jpa;

import com.uptc.frw.newspaper.domain.involvementType.entity.InvolvementType;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface InvolvementTypeMapper {
    InvolvementTypeMapper INSTANCE = Mappers.getMapper( InvolvementTypeMapper.class );

    InvolvementTypeDTO toDto(InvolvementType involvementType, @Context CycleAvoidingMappingContext context);

    InvolvementType toDomain(InvolvementTypeDTO involvementTypeDTO, @Context CycleAvoidingMappingContext context);
}
