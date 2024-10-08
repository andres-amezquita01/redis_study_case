package com.uptc.frw.newspaper.domain.involved.entity;

import java.time.ZonedDateTime;

public record Involved(
        Long id,
        String name,
        ZonedDateTime birthDate
) { }
