package com.uptc.frw.newspaper.talk.repository;

import com.uptc.frw.newspaper.domain.talk.entity.Talk;
import com.uptc.frw.newspaper.domain.talk.repository.TalkRepository;
import com.uptc.frw.newspaper.talk.repository.jpa.TalkDto;
import com.uptc.frw.newspaper.talk.repository.jpa.TalkJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalkRepositoryImpl implements TalkRepository {
    private TalkJpaRepository talkJpaRepository;

    public TalkRepositoryImpl(TalkJpaRepository talkJpaRepository) {
        this.talkJpaRepository = talkJpaRepository;
    }

    @Override
    public Optional<Talk> getTalkById(Long talkId) {
        return talkJpaRepository.findById(talkId)
                .map(TalkDto::toDomain);
    }

    @Override
    public List<Talk> getAllTalks() {
        return talkJpaRepository.findAll()
                .stream().map(TalkDto::toDomain)
                .toList();
    }

    @Override
    public Talk insertTalk(Talk talk) {
        final TalkDto talkDto = TalkDto.toDto(talk);
        return talkJpaRepository.save(talkDto).toDomain();
    }

    @Override
    public Optional<Talk> removeTalk(Long talkId) {
        return getTalkById(talkId).map(founTalk ->{
            talkJpaRepository.deleteById(talkId);
            return founTalk;
        });
    }

    @Override
    public Optional<Talk> updateTalk(Talk talk, Long talkId) {
        final TalkDto newTalkData = TalkDto.toDto(talk);
        return getTalkById(talkId)
                .map(TalkDto::toDto)
                .map(talkDtoToUpdate ->{
                    talkDtoToUpdate.transcription = newTalkData.transcription;
                    talkDtoToUpdate.involvement = newTalkData.involvement;
                    talkDtoToUpdate.reportCover = newTalkData.reportCover;
                    return talkJpaRepository.save(talkDtoToUpdate).toDomain();
                });
    }
}
