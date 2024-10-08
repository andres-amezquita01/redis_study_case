package com.uptc.frw.newspaper.agency.repository.jpa;

import com.uptc.frw.newspaper.domain.agency.entity.Agency;
import com.uptc.frw.newspaper.report.repository.jpa.ReportSubmissionDto;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Agency")
public class AgencyDto {
    @Id
    @Column(name = "id_agency")
    public long id;
    @Column(name = "name_agency")
    public String name;
    @Column(name = "created_at_agency")
    public ZonedDateTime createdAt;

    @OneToMany(mappedBy = "agency")
    public List<ReportSubmissionDto> reportSubmissions;

    public Agency toDomain(){
        return AgencyMapper.INSTANCE.toDomain(this, new CycleAvoidingMappingContext());
    }

    public static AgencyDto fromAgency(final Agency agency){
        return AgencyMapper.INSTANCE.toDto(agency, new CycleAvoidingMappingContext());
    }
}
