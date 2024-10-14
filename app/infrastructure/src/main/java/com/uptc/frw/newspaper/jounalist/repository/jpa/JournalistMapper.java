package com.uptc.frw.newspaper.jounalist.repository.jpa;

import com.uptc.frw.newspaper.domain.jounalist.entity.Journalist;
import com.uptc.frw.newspaper.report.repository.jpa.ReportCoverMapper;
import com.uptc.frw.newspaper.report.repository.jpa.ReportSubmissionMapper;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import jakarta.persistence.JoinColumn;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ReportCoverMapper.class)
public interface JournalistMapper {

    JournalistMapper INSTANCE = Mappers.getMapper(JournalistMapper.class);

    JournalistDto toDto(Journalist journalist, @Context CycleAvoidingMappingContext context);

    Journalist toDomain(JournalistDto dto,  @Context CycleAvoidingMappingContext context);
}
