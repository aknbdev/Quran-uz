package io.quran.app.service.impl;
import io.quran.app.mapper.verse.VerseMapper;
import io.quran.app.payload.verse.VerseDto;
import io.quran.app.payload.verse.VerseJuzRequest;
import io.quran.app.payload.verse.VersesAfterReq;
import io.quran.app.service.VerseDetailService;
import io.quran.app.service.VerseService;
import io.quran.db.entity.verse.Verse;
import io.quran.db.entity.verse.VerseDetail;
import io.quran.db.repository.verse.VerseRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class VerseServiceImpl implements VerseService {
    private final VerseDetailService verseDetailService;
    private final VerseMapper verseMapper;
    private final VerseRepository verseRepository;

    public VerseServiceImpl(VerseDetailService verseDetailService, VerseMapper verseMapper, VerseRepository verseRepository) {
        this.verseDetailService = verseDetailService;
        this.verseMapper = verseMapper;
        this.verseRepository = verseRepository;
    }

    @Override
    public List<VerseDto> getAllBySurahId(Integer surahId, Integer langId) {

        List<Verse> verses = verseRepository.findAllBySurahId(surahId);
        return listChangerToDtoList(verses, verseDetailService.getVerseDetails(getIds(verses)));
    }

    @Override
    public List<VerseDto> findAllByJuzRequest(VerseJuzRequest req) {

        List<Verse> verses = verseRepository.findBySurahIdAndOrderNumberRange(req.getSurahId(), req.getBegin(), req.getEnd());
        return listChangerToDtoList(verses, verseDetailService.getVerseDetails(getIds(verses)));
    }

    @Override
    public List<VerseDto> getVersesAfter(VersesAfterReq req) {

        List<Verse> verses = verseRepository.findBySurahIdAndOrderNumberGreaterThan(req.getSurahId(), req.getIdAfter());
        return listChangerToDtoList(verses, verseDetailService.getVerseDetails(getIds(verses)));
    }

    private List<VerseDto> listChangerToDtoList(List<Verse> verses, List<VerseDetail> verseDetails) {

        List<VerseDto> verseDtoList = new LinkedList<>();
        for (int i = 0; i < verses.size(); i++) {
            verseDtoList.add(verseMapper.toVerseDto(verses.get(i), verseDetails.get(i)));
        }
        return verseDtoList;
    }

    public <T extends Verse> List<Integer> getIds(List<T> verse) {
        List<Integer> ids = new ArrayList<>();
        for (T v : verse) {
            ids.add(v.getId());
        }
        return ids;
    }
}/* |->  DEPRECATED THINGS   <-|

 */