package com.uptc.frw.newspaper.application.involved;

import com.uptc.frw.newspaper.application.shared.BaseUseCases;
import com.uptc.frw.newspaper.domain.involved.entity.Involved;
import com.uptc.frw.newspaper.domain.involved.repository.InvolvedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvolvedUseCases extends BaseUseCases<Involved> {

    private final InvolvedRepository involvedRepository;

    public InvolvedUseCases(InvolvedRepository involvedRepository) {
        this.involvedRepository = involvedRepository;
    }

    @Override
    public Involved add(Involved input) {
        return involvedRepository.insertInvolved(input);
    }

    @Override
    public Optional<Involved> remove(Long entityId) {
        return involvedRepository.removeInvolved(entityId);
    }

    @Override
    public List<Involved> listAll() {
        return involvedRepository.getAllInvolved();
    }

    @Override
    public Optional<Involved> get(Long entityId) {
        return involvedRepository.getInvolvedById(entityId);
    }

    @Override
    public Optional<Involved> update(Involved input, Long entityId) {
        return involvedRepository.updateInvolved(entityId, input);
    }
}
