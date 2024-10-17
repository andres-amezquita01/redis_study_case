package com.uptc.frw.newspaper.domain.involved.repository;


import com.uptc.frw.newspaper.domain.involved.entity.Involved;

import java.util.List;
import java.util.Optional;

public interface InvolvedRepository {

    public Optional<Involved> getInvolvedById(final Long involvedId);
    public List<Involved> getAllInvolved();
    public Involved insertInvolved(final Involved involvedId);
    public Optional<Involved> removeInvolved(final Long involvedId);
    public Optional<Involved> updateInvolved(final Long involvedId, final Involved involved);
}
