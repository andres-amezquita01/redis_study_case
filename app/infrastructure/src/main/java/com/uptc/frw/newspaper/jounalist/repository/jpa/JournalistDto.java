package com.uptc.frw.newspaper.jounalist.repository.jpa;

import com.uptc.frw.newspaper.domain.jounalist.entity.Journalist;
import com.uptc.frw.newspaper.report.repository.jpa.ReportCoverDto;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name = "Journalist")
@Data
public class JournalistDto {
    @Id
    @Column(name = "id_journalist")
    public long id;
    @Column(name = "name_journalist")
    public String name;
    @Column(name = "address_journalist")
    public String address;
    @Column(name = "phone_journalist")
    public String phoneNumber;
    @OneToMany(mappedBy = "journalist")
    public List<ReportCoverDto> reportCovers;

    public Journalist toDomain() {
        return JournalistMapper.INSTANCE.toDomain(this, new CycleAvoidingMappingContext());
    }

    public static JournalistDto fromJournalist(final Journalist journalist) {
        return JournalistMapper.INSTANCE.toDto(journalist, new CycleAvoidingMappingContext());
    }
}
