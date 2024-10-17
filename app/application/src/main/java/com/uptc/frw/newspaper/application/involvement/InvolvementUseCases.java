package com.uptc.frw.newspaper.application.involvement;

import com.uptc.frw.newspaper.application.shared.BaseUseCases;
import com.uptc.frw.newspaper.domain.involvement.entity.Involvement;
import com.uptc.frw.newspaper.domain.involvement.repository.InvolvementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvolvementUseCases extends BaseUseCases<Involvement> {
    private InvolvementRepository involvementRepository;

    public InvolvementUseCases(InvolvementRepository involvementRepository) {
        this.involvementRepository = involvementRepository;
    }

    @Override
    public Involvement add(Involvement input) {
        return involvementRepository.insertInvolvement(input);
    }

    @Override
    public Optional<Involvement> remove(Long entityId) {
        return involvementRepository.removeInvolvement(entityId);
    }

    @Override
    public List<Involvement> listAll() {
        return involvementRepository.getAllInvolvements();
    }

    @Override
    public Optional<Involvement> get(Long entityId) {
        return involvementRepository.getInvolvementById(entityId);
    }

    @Override
    public Optional<Involvement> update(Involvement input, Long entityId) {
        return involvementRepository.updateInvolvement(input, entityId);
    }
}
