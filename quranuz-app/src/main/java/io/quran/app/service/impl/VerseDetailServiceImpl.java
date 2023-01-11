package io.quran.app.service.impl;

import io.quran.app.service.VerseDetailService;
import io.quran.core.exception.BadRequestException;
import io.quran.db.entity.verse.VerseDetail;
import io.quran.db.repository.verse.VerseDetailRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VerseDetailServiceImpl implements VerseDetailService {
    private final VerseDetailRepository verseDetailRepository;

    public VerseDetailServiceImpl(VerseDetailRepository verseDetailRepository) {
        this.verseDetailRepository = verseDetailRepository;
    }

    public List<VerseDetail> getVerseDetails(List<Integer> verseIds, Integer authorId, Integer langId) {
        List<VerseDetail> allByVerseIdIn = verseDetailRepository.findAllByVerseIdInAndAuthorId(verseIds, authorId, langId);
        if (allByVerseIdIn.isEmpty()) {
            throw new BadRequestException("went.wrong");
        }
        return allByVerseIdIn;
    }
}/*|-> DEPRECATED THINGS <-|

 */