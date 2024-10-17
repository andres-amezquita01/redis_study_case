package com.uptc.frw.newspaper.domain.involvement.repository;

import com.uptc.frw.newspaper.domain.involvement.entity.Involvement;
import com.uptc.frw.newspaper.domain.report.entity.Report;

import java.util.List;
import java.util.Optional;

public interface InvolvementRepository {

    public Optional<Involvement> getInvolvementById(final Long involvementId);
    public List<Involvement> getAllInvolvements();
    public Involvement insertInvolvement(final Involvement involvement);
    public Optional<Involvement> removeInvolvement(final Long involvementId);
    public Optional<Involvement> updateInvolvement(final Involvement involvement, final Long involvementId);
}
