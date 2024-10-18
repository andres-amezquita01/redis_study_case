package com.uptc.frw.newspaper.talk.repository.jpa;

import com.uptc.frw.newspaper.domain.involvement.entity.Involvement;
import com.uptc.frw.newspaper.domain.report.entity.ReportCover;
import com.uptc.frw.newspaper.domain.talk.entity.Talk;
import com.uptc.frw.newspaper.involvement.repository.jpa.InvolvementDto;
import com.uptc.frw.newspaper.report.repository.jpa.ReportCoverDto;
import com.uptc.frw.newspaper.report.repository.jpa.ReportCoverMapper;
import com.uptc.frw.newspaper.shared.CycleAvoidingMappingContext;
import jakarta.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "Talk")
public class TalkDto {
    @Id
    @Column(name = "id_talk")
    public Long id;
    @Column(name = "id_report_cover", updatable = false, insertable = false)
    public Long idReportCover;
    @Column(name = "id_involvement", updatable = false, insertable = false)
    public Long idEnvolvement;
    @Column(name = "transcription_talk")
    public String transcription;

    @ManyToOne
    @JoinColumn(name = "id_report_cover")
    public ReportCoverDto reportCover;
    @ManyToOne
    @JoinColumn(name = "id_involvement")
    public InvolvementDto involvement;


    public Talk toDomain(){
        return TalkMapper.INSTANCE.toDomain(this, new CycleAvoidingMappingContext());
    }
    public static TalkDto toDto(final Talk talk){
        return TalkMapper.INSTANCE.toDto(talk, new CycleAvoidingMappingContext());
    }
}
