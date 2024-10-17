package com.uptc.frw.newspaper.involved.repository.jpa;

import com.uptc.frw.newspaper.domain.involved.entity.Involved;
import com.uptc.frw.newspaper.involvement.jpa.InvolvementDto;
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
@Table(name = "Involved")
public class InvolvedDto {

    @Id
    @Column(name = "id_involved")
    public long id;

    @Column(name = "name_involved")
    public String name;

    @Column(name = "birth_date_involved")
    public ZonedDateTime birthDate;

    @OneToMany(mappedBy = "involved")
    List<InvolvementDto> involvements;

    public Involved toDomain(){
        return InvolvedMapper.INSTANCE.toDomain(this, new CycleAvoidingMappingContext());
    }

    public static InvolvedDto fromAgency(final Involved agency){
        return InvolvedMapper.INSTANCE.toDto(agency, new CycleAvoidingMappingContext());
    }

}