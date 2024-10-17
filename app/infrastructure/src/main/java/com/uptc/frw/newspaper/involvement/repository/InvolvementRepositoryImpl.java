package com.uptc.frw.newspaper.involvement.repository;

import com.uptc.frw.newspaper.domain.involvement.entity.Involvement;
import com.uptc.frw.newspaper.domain.involvement.repository.InvolvementRepository;
import com.uptc.frw.newspaper.involvement.repository.jpa.InvolvementDto;
import com.uptc.frw.newspaper.involvement.repository.jpa.InvolvementJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InvolvementRepositoryImpl implements InvolvementRepository {
    private final InvolvementJpaRepository involvementJpaRepository;

    public InvolvementRepositoryImpl(InvolvementJpaRepository involvementJpaRepository) {
        this.involvementJpaRepository = involvementJpaRepository;
    }

    @Override
    public Optional<Involvement> getInvolvementById(final Long involvementId) {
        return involvementJpaRepository.findById(involvementId).map(InvolvementDto::toDomain);
    }

    @Override
    public List<Involvement> getAllInvolvements() {
        return involvementJpaRepository
                .findAll()
                .stream()
                .map(InvolvementDto::toDomain)
                .toList();
    }

    @Override
    public Involvement insertInvolvement(final Involvement involvement) {
        final InvolvementDto involvementDtoToSave = InvolvementDto.fromInvolvement(involvement);
        return involvementJpaRepository.save(involvementDtoToSave).toDomain();
    }

    @Override
    public Optional<Involvement> removeInvolvement(final Long involvementId) {
        return getInvolvementById(involvementId).map(involvement -> {
            involvementJpaRepository.deleteById(involvementId);
            return involvement;
        });
    }

    @Override
    public Optional<Involvement> updateInvolvement(Involvement involvement, Long involvementId) {
        final InvolvementDto newInvolvementData = InvolvementDto.fromInvolvement(involvement);
        return  getInvolvementById(involvementId)
                .map(InvolvementDto::fromInvolvement)
                .map(involvementDtoToUpdate -> {
                    involvementDtoToUpdate.report = newInvolvementData.report;
                    involvementDtoToUpdate.involved = newInvolvementData.involved;
                    involvementDtoToUpdate.involvementType = newInvolvementData.involvementType;
                    return involvementJpaRepository.save(involvementDtoToUpdate);
                }).map(InvolvementDto::toDomain);
    }
}
