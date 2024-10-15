package com.uptc.frw.newspaper.involvementType.repository.jpa;

import com.uptc.frw.newspaper.domain.involvementType.entity.InvolvementType;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "InvolvementType")
public class InvolvementTypeDTO {
    @Id
    @Column(name = "id_involvement_type")
    public long id;
    @Column(name = "title_involvement_type")
    public String title;
    @Column(name = "description_involvement_type")
    public String description;

    public InvolvementType toDomain(){
        return InvolvementTypeMapper.INSTANCE.toDomain(this, new CycleAvoidingMappingContext());
    }

    public static InvolvementTypeDTO fromInvolvementType(final InvolvementType involvementType){
        return InvolvementTypeMapper.INSTANCE.toDto(involvementType, new CycleAvoidingMappingContext());
    }
}
