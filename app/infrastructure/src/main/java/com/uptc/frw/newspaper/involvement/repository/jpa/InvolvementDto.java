package com.uptc.frw.newspaper.involvement.repository.jpa;

import com.uptc.frw.newspaper.involved.repository.jpa.InvolvedDto;
import com.uptc.frw.newspaper.involvementType.repository.jpa.InvolvementTypeDTO;
import com.uptc.frw.newspaper.report.repository.jpa.ReportDto;
import jakarta.persistence.*;

@Entity
@Table(name = "Involvement")
public class InvolvementDto {

    @Id
    @Column(name = "id_involvement")
    public long id;

    @ManyToOne()
    @JoinColumn(name = "id_report")
    public ReportDto involmentReport;

    @ManyToOne()
    @JoinColumn(name = "id_involved")
    public InvolvedDto involved;

    //@Column(name = "id_involvement_type")
    //public InvolvementTypeDTO type;

    //Talk

}
