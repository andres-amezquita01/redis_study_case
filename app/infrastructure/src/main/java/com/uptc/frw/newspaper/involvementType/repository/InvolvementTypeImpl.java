package com.uptc.frw.newspaper.involvementType.repository;

import com.uptc.frw.newspaper.agency.repository.jpa.AgencyDto;
import com.uptc.frw.newspaper.domain.involvementType.entity.InvolvementType;
import com.uptc.frw.newspaper.domain.involvementType.repository.InvolvementTypeRepository;
import com.uptc.frw.newspaper.involvementType.repository.jpa.InvolvementTypeDTO;
import com.uptc.frw.newspaper.involvementType.repository.jpa.InvolvementTypeJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvolvementTypeImpl implements InvolvementTypeRepository {
    private InvolvementTypeJpaRepository jpaRepository;

    public InvolvementTypeImpl(InvolvementTypeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<InvolvementType> getInvolvementTypeById(Long involvementTypeId) {
        return jpaRepository.findById(involvementTypeId).map(InvolvementTypeDTO::toDomain);
    }
    @Override
    public List<InvolvementType> getAllInvolvementTypes() {
        return jpaRepository.findAll().stream().map(InvolvementTypeDTO::toDomain).toList();
    }

    @Override
    public InvolvementType insertInvolvementType(InvolvementType involvementType) {
        final InvolvementTypeDTO involvementTypeToSave = InvolvementTypeDTO.fromInvolvementType(involvementType);
        return jpaRepository.save(involvementTypeToSave).toDomain();
    }

    @Override
    public Optional<InvolvementType> removeInvolvementType(Long involvementTypeId) {
        return getInvolvementTypeById(involvementTypeId).map(involvementType -> {
            jpaRepository.deleteById(involvementTypeId);
            return involvementType;
        });
    }

    @Override
    public Optional<InvolvementType> updateInvolvementType(InvolvementType involvementType, Long involvementTypeId) {
        final InvolvementTypeDTO newInvolvementTypeData = InvolvementTypeDTO.fromInvolvementType(involvementType);
        return getInvolvementTypeById(involvementTypeId)
                .map(InvolvementTypeDTO::fromInvolvementType)
                .map(involvementTypeToUpdate -> {
                    involvementTypeToUpdate.title = newInvolvementTypeData.title;
                    involvementTypeToUpdate.description = newInvolvementTypeData.description;
                    return jpaRepository.save(involvementTypeToUpdate);
                }).map(InvolvementTypeDTO::toDomain);
    }
}
