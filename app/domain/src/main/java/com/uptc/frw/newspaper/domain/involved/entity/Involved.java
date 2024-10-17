package com.uptc.frw.newspaper.domain.involved.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.frw.newspaper.domain.involvement.Involvement;

import java.time.ZonedDateTime;
import java.util.List;

public record Involved (
        Long id,
        String name,
        ZonedDateTime birthDate,
        @JsonIgnore
        List<Involvement> involvements
) { }
