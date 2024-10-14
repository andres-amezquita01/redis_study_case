package com.uptc.frw.newspaper.domain.jounalist.entity.repository;

import com.uptc.frw.newspaper.domain.jounalist.entity.Journalist;
import java.util.*;

public interface JournalistRepository {
    Optional<Journalist> getJournalistById(final Long journalistId);
    List<Journalist> getAllJournalists();
    Journalist insertJournalist(final Journalist journalist);
    Optional<Journalist> removeJournalist(final Long journalistId);
    Optional<Journalist> updateJournalist(final Long journalistId, final Journalist journalist);
}
