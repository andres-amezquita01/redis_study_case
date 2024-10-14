package com.uptc.frw.newspaper.application.journalist;

import com.uptc.frw.newspaper.application.shared.BaseUseCases;
import com.uptc.frw.newspaper.domain.jounalist.entity.Journalist;
import com.uptc.frw.newspaper.domain.jounalist.entity.repository.JournalistRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class JournalistUseCases extends BaseUseCases<Journalist> {

    private final JournalistRepository journalistRepository;

    public JournalistUseCases(JournalistRepository journalistRepository) {
        this.journalistRepository = journalistRepository;
    }

    @Override
    public Journalist add(Journalist input) {
        return journalistRepository.insertJournalist(input);
    }

    @Override
    public Optional<Journalist> remove(Long entityId) {
        return journalistRepository.removeJournalist(entityId);
    }

    @Override
    public List<Journalist> listAll() {
        return journalistRepository.getAllJournalists();
    }

    @Override
    public Optional<Journalist> get(Long entityId) {
        return journalistRepository.getJournalistById(entityId);
    }

    @Override
    public Optional<Journalist> update(Journalist input, Long entityId) {
        return journalistRepository.updateJournalist(entityId, input);
    }
}
