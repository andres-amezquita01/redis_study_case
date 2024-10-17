package com.uptc.frw.newspaper.involved.repository;

import com.uptc.frw.newspaper.domain.involved.entity.Involved;
import com.uptc.frw.newspaper.domain.involved.repository.InvolvedRepository;
import com.uptc.frw.newspaper.involved.repository.jpa.InvolvedDto;
import com.uptc.frw.newspaper.involved.repository.jpa.InvolvedJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvolvedRepositoryImpl implements InvolvedRepository {

    private final InvolvedJpaRepository jpaRepository;

    public InvolvedRepositoryImpl(InvolvedJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Involved> getInvolvedById(Long involvedId) {
        return jpaRepository.findById(involvedId)
                .map(InvolvedDto::toDomain);
    }

    @Override
    public List<Involved> getAllInvolved() {
        return jpaRepository.findAll()
                .stream()
                .map(InvolvedDto::toDomain)
                .toList();
    }

    @Override
    public Involved insertInvolved(Involved involvedId) {
        final var involvedToSave = InvolvedDto.fromAgency(involvedId);
        return jpaRepository.save(involvedToSave).toDomain();
    }

    @Override
    public Optional<Involved> removeInvolved(Long involvedId) {
        return getInvolvedById(involvedId).map(involved -> {
            jpaRepository.deleteById(involvedId);
            return involved;
        });
    }

    @Override
    public Optional<Involved> updateInvolved(Long involvedId, Involved involved) {
        final var newInvolvedData = InvolvedDto.fromAgency(involved);
        return getInvolvedById(involvedId)
                .map(InvolvedDto::fromAgency)
                .map(involvedToUpdate -> {
                    involvedToUpdate.name = newInvolvedData.name;
                    involvedToUpdate.birthDate = newInvolvedData.birthDate;
                    return jpaRepository.save(involvedToUpdate);
                }).map(InvolvedDto::toDomain);
    }
}
