package com.uptc.frw.newspaper.application.talk;

import com.uptc.frw.newspaper.application.shared.BaseUseCases;
import com.uptc.frw.newspaper.domain.talk.entity.Talk;
import com.uptc.frw.newspaper.domain.talk.repository.TalkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalkUseCases extends BaseUseCases<Talk> {
    private final TalkRepository talkRepository;

    public TalkUseCases(TalkRepository talkRepository) {
        this.talkRepository = talkRepository;
    }

    @Override
    public Talk add(Talk input) {
        return talkRepository.insertTalk(input);
    }

    @Override
    public Optional<Talk> remove(Long entityId) {
        return talkRepository.removeTalk(entityId);
    }

    @Override
    public List<Talk> listAll() {
        return talkRepository.getAllTalks();
    }

    @Override
    public Optional<Talk> get(Long entityId) {
        return talkRepository.getTalkById(entityId);
    }

    @Override
    public Optional<Talk> update(Talk input, Long entityId) {
        return talkRepository.updateTalk(input,entityId);
    }
}
