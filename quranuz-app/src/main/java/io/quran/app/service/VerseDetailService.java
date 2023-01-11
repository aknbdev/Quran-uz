package io.quran.app.service;


import io.quran.db.entity.verse.VerseDetail;

import java.util.List;

public interface VerseDetailService {

    List<VerseDetail> getVerseDetails(List<Integer> verseIds, Integer authorId, Integer langId);
}