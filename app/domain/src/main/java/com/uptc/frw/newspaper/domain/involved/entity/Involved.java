package com.uptc.frw.newspaper.domain.involved.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.uptc.frw.newspaper.domain.involvement.entity.Involvement;

import java.time.ZonedDateTime;
import java.util.List;

public record Involved (
        Long id,
        String name,
        ZonedDateTime birthDate,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        List<Involvement> involvements
) { }
