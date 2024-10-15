package com.uptc.frw.newspaper.application.involvementType;

import com.uptc.frw.newspaper.application.shared.BaseUseCases;
import com.uptc.frw.newspaper.domain.involvementType.entity.InvolvementType;
import com.uptc.frw.newspaper.domain.involvementType.repository.InvolvementTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class InvolvementTypeUseCases extends BaseUseCases<InvolvementType> {
    private final InvolvementTypeRepository involvementTypeRepository;

    public InvolvementTypeUseCases(InvolvementTypeRepository involvementTypeRepository) {
        this.involvementTypeRepository = involvementTypeRepository;
    }

    @Override
    public InvolvementType add(InvolvementType input) {
        return involvementTypeRepository.insertInvolvementType(input);
    }

    @Override
    public Optional<InvolvementType> remove(Long entityId) {
        return involvementTypeRepository.removeInvolvementType(entityId);
    }

    @Override
    public List<InvolvementType> listAll() {
        return involvementTypeRepository.getAllInvolvementTypes();
    }

    @Override
    public Optional<InvolvementType> get(Long entityId) {
        return involvementTypeRepository.getInvolvementTypeById(entityId);
    }

    @Override
    public Optional<InvolvementType> update(InvolvementType input, Long entityId) {
        return involvementTypeRepository.updateInvolvementType(input,entityId);
    }
}
