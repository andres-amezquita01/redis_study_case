package com.uptc.frw.newspaper.involvement.repository.jpa;

import com.uptc.frw.newspaper.domain.involvement.entity.Involvement;
import com.uptc.frw.newspaper.involved.repository.jpa.InvolvedDto;
import com.uptc.frw.newspaper.involvementType.repository.jpa.InvolvementTypeDTO;
import com.uptc.frw.newspaper.report.repository.jpa.ReportDto;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "Involvement")
public class InvolvementDto {
    @Id
    @Column(name = "id_involvement")
    public long id;
    @Column(name = "id_involved", updatable = false, insertable = false)
    public long idInvolved;
    @Column(name = "id_report", updatable = false, insertable = false)
    public long idReport;
    @Column(name = "id_involvement_type", updatable = false, insertable = false)
    public long idInvolvementType;

    @ManyToOne
    @JoinColumn(name = "id_involved")
    public InvolvedDto involved;
    @ManyToOne
    @JoinColumn(name = "id_report")
    public ReportDto report;
    @ManyToOne
    @JoinColumn(name = "id_involvement_type")
    public InvolvementTypeDTO involvementType;

    public Involvement toDomain(){
        return InvolvementMapper.INSTANCE.toDomain(this, new CycleAvoidingMappingContext());
    }
    public static InvolvementDto fromInvolvement(final Involvement involvement){
        return InvolvementMapper.INSTANCE.toDto(involvement, new CycleAvoidingMappingContext());
    }
}
