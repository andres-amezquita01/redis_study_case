package com.uptc.frw.newspaper.jounalist.repository;

import com.uptc.frw.newspaper.domain.jounalist.entity.Journalist;
import com.uptc.frw.newspaper.domain.jounalist.entity.repository.JournalistRepository;
import com.uptc.frw.newspaper.jounalist.repository.jpa.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JournalistRepositoryImpl implements JournalistRepository {

    private final JournalistJpaRepository jpaRepository;

    public JournalistRepositoryImpl(JournalistJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Journalist> getJournalistById(final Long journalistId) {
        return jpaRepository.findById(journalistId)
                .map(JournalistDto::toDomain);
    }

    @Override
    public List<Journalist> getAllJournalists() {
        return jpaRepository
                .findAll()
                .stream()
                .map(JournalistDto::toDomain)
                .toList();
    }

    @Override
    public Journalist insertJournalist(final Journalist journalist) {
        final var journalistToSave = JournalistDto.fromJournalist(journalist);
        return jpaRepository.save(journalistToSave).toDomain();
    }

    @Override
    public Optional<Journalist> removeJournalist(final Long journalistId) {
        return getJournalistById(journalistId).map(journalist -> {
            jpaRepository.deleteById(journalistId);
            return journalist;
        });
    }

    @Override
    public Optional<Journalist> updateJournalist(final Long journalistId, final Journalist journalist) {
        final var newJournalistData = JournalistDto.fromJournalist(journalist);
        return getJournalistById(journalistId)
                .map(JournalistDto::fromJournalist)
                .map(journalistToUpdate -> {
                    journalistToUpdate.name = newJournalistData.name;
                    journalistToUpdate.phoneNumber = newJournalistData.phoneNumber;
                    journalistToUpdate.address = newJournalistData.address;
                    return jpaRepository.save(journalistToUpdate);
                }).map(JournalistDto::toDomain);
    }
}