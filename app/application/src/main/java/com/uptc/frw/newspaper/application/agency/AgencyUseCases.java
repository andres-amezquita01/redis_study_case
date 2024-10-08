package com.uptc.frw.newspaper.application.agency;

import com.uptc.frw.newspaper.application.shared.BaseUseCases;
import com.uptc.frw.newspaper.domain.agency.entity.Agency;
import com.uptc.frw.newspaper.domain.agency.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AgencyUseCases extends BaseUseCases<Agency> {

    private final AgencyRepository agencyRepository;

    public AgencyUseCases(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public Agency add(Agency input) {
        return agencyRepository.insertAgency(input);
    }

    @Override
    public Optional<Agency> remove(Long entityId) {
        return agencyRepository.removeAgency(entityId);
    }

    @Override
    public List<Agency> listAll() {
        return agencyRepository.getAllAgencies();
    }

    @Override
    public Optional<Agency> get(Long entityId) {
        return agencyRepository.getAgencyById(entityId);
    }

    @Override
    public Optional<Agency> update(Agency input, Long entityId) {
        return agencyRepository.updateAgency(entityId, input);
    }
}
