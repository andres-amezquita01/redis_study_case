package com.uptc.frw.newspaper.agency.repository;

import com.uptc.frw.newspaper.agency.repository.jpa.AgencyDto;
import com.uptc.frw.newspaper.agency.repository.jpa.AgencyJpaRepository;
import com.uptc.frw.newspaper.domain.agency.entity.Agency;
import com.uptc.frw.newspaper.domain.agency.repository.AgencyRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AgencyRepositoryImpl  implements AgencyRepository {

    private final AgencyJpaRepository jpaRepository;

    AgencyRepositoryImpl(AgencyJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Cacheable(value = "agency", key = "#agencyId")
    public Optional<Agency> getAgencyById(Long agencyId) {
        return jpaRepository
                .findById(agencyId)
                .map(AgencyDto::toDomain);
    }

    @Override
    @Cacheable(value = "agencies")
    public List<Agency> getAllAgencies() {
        return jpaRepository
                .findAll()
                .stream()
                .map(AgencyDto::toDomain)
                .toList();
    }

    @Override
    public Agency insertAgency(Agency agency) {
        final var agencyToSave = AgencyDto.fromAgency(agency);
        return jpaRepository.save(agencyToSave).toDomain();
    }

    @Override
    public Optional<Agency> removeAgency(Long agencyId) {
        return getAgencyById(agencyId).map(agency -> {
            jpaRepository.deleteById(agencyId);
            return agency;
        });
    }

    @Override
    public Optional<Agency> updateAgency(Long agencyId, Agency agency) {
        final var newAgencyData = AgencyDto.fromAgency(agency);
        return getAgencyById(agencyId)
                .map(AgencyDto::fromAgency)
                .map(agencyToUpdate -> {
                    agencyToUpdate.name = newAgencyData.name;
                    agencyToUpdate.createdAt = newAgencyData.createdAt;
                    return jpaRepository.save(agencyToUpdate);
                }).map(AgencyDto::toDomain);
    }
}
