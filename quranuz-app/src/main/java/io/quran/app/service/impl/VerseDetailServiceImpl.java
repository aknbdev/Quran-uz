package io.quran.app.service.impl;

import io.quran.app.mapper.VerseMapper;
import io.quran.app.payload.verse.VerseBeginEndReq;
import io.quran.app.payload.verse.VerseDto;
import io.quran.app.payload.verse.VerseSurahReq;
import io.quran.app.payload.verse.VersesAfterReq;
import io.quran.app.service.VerseDetailService;
import io.quran.core.exception.BadRequestException;
import io.quran.db.entity.verse.VerseDetail;
import io.quran.db.repository.verse.VerseDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VerseDetailServiceImpl implements VerseDetailService {
    private final VerseDetailRepository verseDetailRepository;
    private final VerseMapper verseMapper;

    public VerseDetailServiceImpl(VerseDetailRepository verseDetailRepository,
                                  VerseMapper verseMapper) {
        this.verseDetailRepository = verseDetailRepository;
        this.verseMapper = verseMapper;
    }

    public List<VerseDetail> getVerseDetails(List<Integer> verseIds, Integer authorId, Integer langId) {
        List<VerseDetail> allByVerseIdIn = verseDetailRepository.findAllByVerseIdInAndAuthorId(verseIds, authorId, langId);
        if (allByVerseIdIn.isEmpty()) {
            throw new BadRequestException("went.wrong");
        }
        return allByVerseIdIn;
    }

    @Override
    public List<VerseDto> getAllBySurahId(VerseSurahReq req) {

        return verseDetailRepository.findAllByVerseSurahIdAndAndAuthorIdAndLanguageId(
                        req.getSurahId(),
                        req.getAuthorId(),
                        req.getLangId()
                ).stream()
                .map(verseMapper::toVerseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VerseDto> findAllByJuzRequest(VerseBeginEndReq req) {

        return verseDetailRepository.findBySurahIdAndOrderNumberRange(
                        req.getSurahId(),
                        req.getBegin(),
                        req.getEnd(),
                        req.getAuthorId(),
                        req.getLangId()
                ).stream()
                .map(verseMapper::toVerseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VerseDto> getVersesAfter(VersesAfterReq req) {

        return verseDetailRepository.findBySurahIdAndOrderNumberGreaterThan(
                        req.getSurahId(),
                        req.getIdAfter(),
                        req.getAuthorId(),
                        req.getLangId()
                ).stream()
                .map(verseMapper::toVerseDto)
                .collect(Collectors.toList());
    }
}/*|-> DEPRECATED THINGS <-|

 */