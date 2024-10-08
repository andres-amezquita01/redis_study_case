package com.uptc.frw.newspaper.domain.involved.repository;


import com.uptc.frw.newspaper.domain.involved.entity.Involved;

public interface InvolvedRepository {
    public void getInvolvedById(final Long involvedId);
    public void getAllInvolved();
    public void insertInvolved(final Involved involvedId);
    public void removeInvolved(final Long involvedId);
    public void updateInvolved(final Long involvedId, final Involved involved);
}
