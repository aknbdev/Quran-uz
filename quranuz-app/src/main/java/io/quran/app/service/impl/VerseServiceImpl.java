package io.quran.app.service.impl;

import io.quran.app.mapper.VerseMapper;
import io.quran.app.payload.verse.VerseBeginEndReq;
import io.quran.app.payload.verse.VerseDto;
import io.quran.app.payload.verse.VerseSurahReq;
import io.quran.app.payload.verse.VersesAfterReq;
import io.quran.app.service.VerseDetailService;
import io.quran.app.service.VerseService;
import io.quran.db.entity.verse.Verse;
import io.quran.db.entity.verse.VerseDetail;
import io.quran.db.repository.verse.VerseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VerseServiceImpl implements VerseService {
    private final VerseDetailService verseDetailService;
    private final VerseMapper verseMapper;
    private final VerseRepository verseRepository;

    public VerseServiceImpl(VerseDetailService verseDetailService,
                            VerseMapper verseMapper,
                            VerseRepository verseRepository) {
        this.verseDetailService = verseDetailService;
        this.verseMapper = verseMapper;
        this.verseRepository = verseRepository;
    }

    @Override
    public List<VerseDto> getAllBySurahId(VerseSurahReq verseSurahReq) {

//        List<Verse> verses = verseRepository.findAllBySurahId(verseSurahReq.getSurahId());
//        return listChangerToDtoList(verses, verseDetailService.getVerseDetails(getIds(verses), verseSurahReq.getAuthorId(), verseSurahReq.getLangId()));
        return null;
    }

    @Override
    public List<VerseDto> findAllByJuzRequest(VerseBeginEndReq req) {

//        List<Verse> verses = verseRepository.findBySurahIdAndOrderNumberRange(req.getSurahId(), req.getBegin(), req.getEnd());
//        return listChangerToDtoList(verses, verseDetailService.getVerseDetails(getIds(verses), req.getAuthorId(), req.getLangId()));
        return null;
    }

    @Override
    public List<VerseDto> getVersesAfter(VersesAfterReq req) {

//        List<Verse> verses = verseRepository.findBySurahIdAndOrderNumberGreaterThan(req.getSurahId(), req.getIdAfter());
//        return listChangerToDtoList(verses, verseDetailService.getVerseDetails(getIds(verses), req.getAuthorId(), req.getLangId()));
        return null;
    }

    private List<VerseDto> listChangerToDtoList(List<Verse> verses, List<VerseDetail> verseDetails) {
//        List<VerseDto> verseDtoList = new LinkedList<>();
//        if (!verses.isEmpty() && verses.size() == verseDetails.size()) {
//            IntStream.range(0, verses.size())
//                    .mapToObj(i -> verseMapper.toVerseDto(verses.get(i), verseDetails.get(i)))
//                    .forEach(verseDtoList::add);
//        } else {
//            throw RestException.restThrow("Verse not found", HttpStatus.NOT_FOUND);
//        }
//        return verseDtoList;
        return null;
    }


    public <T extends Verse> List<Integer> getIds(List<T> verses) {
        return verses.stream().map(Verse::getId).collect(Collectors.toList());
    }
}/* |->  DEPRECATED THINGS   <-|

 */