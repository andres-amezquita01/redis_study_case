package com.uptc.frw.newspaper.domain.talk.repository;

import com.uptc.frw.newspaper.domain.report.entity.ReportCover;
import com.uptc.frw.newspaper.domain.talk.entity.Talk;

import java.util.List;
import java.util.Optional;

public interface TalkRepository {
    public Optional<Talk> getTalkById(final Long talkId);
    public List<Talk> getAllTalks();
    public Talk insertTalk(final Talk talk);
    public Optional<Talk> removeTalk(final Long talkId);
    public Optional<Talk> updateTalk(final Talk talk, final Long talkId );
}
