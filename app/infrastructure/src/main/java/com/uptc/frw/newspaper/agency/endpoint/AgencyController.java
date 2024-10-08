package com.uptc.frw.newspaper.agency.endpoint;

import com.uptc.frw.newspaper.application.agency.AgencyUseCases;
import com.uptc.frw.newspaper.domain.agency.entity.Agency;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("agencies")
public class AgencyController {

    public final AgencyUseCases agencyUseCases;

    public AgencyController(AgencyUseCases agencyUseCases) {
        this.agencyUseCases = agencyUseCases;
    }

    @GetMapping
    public List<Agency> getAllAgencies(){
        return agencyUseCases.listAll();
    }

    @GetMapping("/{agencyId}")
    public Agency getAgencyById(@PathVariable Long agencyId){
        return agencyUseCases.get(agencyId).orElseThrow();
    }

    @PostMapping()
    public Agency addAgency(@RequestBody Agency agency) {
        return agencyUseCases.add(agency);
    }

    @DeleteMapping("/{agencyId}")
    public Agency removeAgency(@PathVariable Long agencyId){
        return agencyUseCases.remove(agencyId).orElseThrow();
    }

    @PutMapping()
    public Agency modifyAgency(@RequestParam Long agencyId, @RequestBody Agency agency){
        return agencyUseCases.update(agency, agencyId).orElseThrow();
    }
}
