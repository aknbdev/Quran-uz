package io.quran.app.service.impl;

import io.quran.app.payload.verse.VerseDetailSaveDto;
import io.quran.app.service.VerseDetailService;
import io.quran.db.repository.verse.VerseDetailRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VerseDetailServiceImpl implements VerseDetailService {
    private final VerseDetailRepository verseDetailRepository;
    private final LanguageServiceImpl languageService;
    private final VerseServiceImpl verseService;

    public VerseDetailServiceImpl(VerseDetailRepository verseDetailRepository,
                                  LanguageServiceImpl languageService,
                                  VerseServiceImpl verseService) {
        this.verseDetailRepository = verseDetailRepository;
        this.languageService = languageService;
        this.verseService = verseService;
    }


    @Override
    public VerseDetailSaveDto getOneBySurahIdVerseId(
            Integer surahId,
            Integer verseId,
            String lang) {

        return null;
    }

    @Override
    public List<VerseDetailSaveDto> getVerseDetailBySurahId(Integer surahId, String lang) {

        return null;
    }

    @Override
    public List<VerseDetailSaveDto> getAllVerseDetail(String lang) {

        return null;
    }
}/*|-> DEPRECATED THINGS <-|

 */