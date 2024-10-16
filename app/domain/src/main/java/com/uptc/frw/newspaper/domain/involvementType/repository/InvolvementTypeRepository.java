package com.uptc.frw.newspaper.domain.involvementType.repository;
import com.uptc.frw.newspaper.domain.involvementType.entity.InvolvementType;

import java.util.List;
import java.util.Optional;

public interface InvolvementTypeRepository {
    public Optional<InvolvementType> getInvolvementTypeById(final Long involvementTypeId);
    public List<InvolvementType> getAllInvolvementTypes();
    public InvolvementType insertInvolvementType(final InvolvementType involvementType);
    public Optional<InvolvementType> removeInvolvementType(final Long involvementTypeId);
    public Optional<InvolvementType> updateInvolvementType(final InvolvementType involved, final Long involvementTypeId);
}
