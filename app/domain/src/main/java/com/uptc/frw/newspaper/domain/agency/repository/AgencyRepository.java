package com.uptc.frw.newspaper.domain.agency.repository;

import com.uptc.frw.newspaper.domain.agency.entity.Agency;

import java.util.*;

public interface AgencyRepository {
    Optional<Agency> getAgencyById(final Long agencyId);
    List<Agency> getAllAgencies();
    Agency insertAgency(final Agency agency);
    Optional<Agency> removeAgency(final Long agencyId);
    Optional<Agency> updateAgency(final Long agencyId, final Agency agency);
}
