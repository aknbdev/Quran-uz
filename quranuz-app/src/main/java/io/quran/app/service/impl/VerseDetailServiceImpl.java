package io.quran.app.service.impl;

import io.quran.app.payload.verse.VerseDetailSaveDto;
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

    public List<VerseDetail> getVerseDetails(List<Integer> verseIds) {
        List<VerseDetail> allByVerseIdIn = verseDetailRepository.findAllByVerseIdIn(verseIds);
        if (allByVerseIdIn.isEmpty()) {
            throw new BadRequestException("went.wrong");
        }
        return allByVerseIdIn;
    }
}/*|-> DEPRECATED THINGS <-|

 */