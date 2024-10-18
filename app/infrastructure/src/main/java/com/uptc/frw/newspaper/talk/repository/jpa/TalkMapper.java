package com.uptc.frw.newspaper.talk.repository.jpa;

import com.uptc.frw.newspaper.domain.talk.entity.Talk;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TalkMapper {
    TalkMapper INSTANCE = Mappers.getMapper(TalkMapper.class);
    Talk toDomain(TalkDto talkDto, @Context CycleAvoidingMappingContext context);
    TalkDto toDto(Talk talk, @Context CycleAvoidingMappingContext context);
}
