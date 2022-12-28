package io.quran.app.service.impl;

import io.quran.app.payload.verse.VerseSaveDto;
import io.quran.app.service.VerseService;
import io.quran.db.repository.verse.VerseDetailRepository;
import io.quran.db.repository.verse.VerseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerseServiceImpl implements VerseService {
    private final VerseRepository verseRepository;
    private final VerseDetailRepository verseDetailRepository;
    private final SurahServiceImpl surahService;

    public VerseServiceImpl(VerseRepository verseRepository,
                            VerseDetailRepository verseDetailRepository,
                            SurahServiceImpl surahService) {
        this.verseRepository = verseRepository;
        this.verseDetailRepository = verseDetailRepository;
        this.surahService = surahService;
    }

    @Override
    public List<VerseSaveDto> getAllBySurahId(Integer id, String lang) {

        return null;
    }

    @Override
    public List<VerseSaveDto> getAllByJuzId(Integer juzId, String lang) {

        return null;
    }
}

/* |->  DEPRECATED THINGS   <-|
@Override
    public void createVerse(VerseDto dto) {
        Verse verse = dtoToVerse(dto);
        // TODO: 08/12/22
        saveToDatabase(verse);
    }

    @Override
    public void updateVerse(Integer id, VerseDto dto) {
        Verse newVerse = dtoToVerse(dto);
        newVerse.setId(id);
        // TODO: 08/12/22
        saveToDatabase(newVerse);
    }

    @Override
    public List<VerseDto> getAllVerses(long millisecond) {

        List<Verse> verses = null;
        // TODO: 08/12/22
//                verseRepository.findAllByUpdatedDateAfter(
//                        TimeConverter.convertToLocalDateTime(millisecond)
//                );

        if (verses.isEmpty()) {
            return Collections.emptyList();
        }

        return verses.stream().map(this::verseToDto).collect(Collectors.toList());
    }

    @Override
    public List<VerseDto> getAllBySurahId(Integer id, long millisecond) {
        return null;
        // TODO: 08/12/22
//                getAllVerseBySurahId(id, TimeConverter.convertToLocalDateTime(millisecond))
//                .stream()
//                .map(this::verseToDto)
//                .collect(Collectors.toList());
    }

    @Override
    public List<VerseDto> getAllByJuzId(Integer juzId,
                                        Integer languageId,
                                        long millisecond) {
        List<Verse> verseList = null;
        // TODO: 08/12/22
//                verseRepository.getAllByJuzId(
//                        juzId,
//                        TimeConverter.convertToLocalDateTime(millisecond)
//                );

        if (verseList.isEmpty()) {
            return Collections.emptyList();
        }

        HashMap<Integer, LinkedList<Integer>> verseIdAndSurahIdMap = new HashMap<>();

        LinkedList<Integer> verseId;
        Set<Integer> surahIds = new HashSet<>();
        for (Verse verse : verseList) {

            if (verseIdAndSurahIdMap.containsKey(verse.getSurahId())) {
                verseIdAndSurahIdMap.get(verse.getSurahId()).add(verse.getOrderNumber());
            } else {
                verseId = new LinkedList<>();
                verseId.add(verse.getOrderNumber());
                surahIds.add(verse.getSurahId());
                verseIdAndSurahIdMap.put(verse.getSurahId(), verseId);
            }
        }

        int u = 0;
        List<VerseDto> verseDtoList = new LinkedList<>();
        for (Integer surahId : surahIds) {
            LinkedList<Integer> integerList = verseIdAndSurahIdMap.get(surahId);
            Integer min = integerList.getFirst();
            Integer max = integerList.getLast();

            List<String> stringList = null;
//                    verseDetailRepository
//                    .findAllVerseDetailByVerseIdAndSurahId(min, max, surahId, languageId);

            VerseDto dto;

            for (String translation : stringList) {
                dto = verseToDto(verseList.get(u));
                dto.setTranslation(translation);
                verseDtoList.add(dto);
                u++;
            }
        }
        return verseDtoList;
    }

    // |- SECONDARY FUNCTIONS -|

    public List<Verse> getAllByJuz(Instant time) {

        int[] juzVerseId = {1, 149, 260, 386, 517, 641, 751, 900,
                1042, 1201, 1328, 1479, 1649, 1803, 2030, 2215, 2484,
                2674, 2876, 3215, 3386, 3564, 3733, 4090, 4256, 4511,
                4706, 5105, 5242, 5673};

        List<Verse> verses = null;
        // TODO: 08/12/22
//                verseRepository.getAllByJuzId(juzVerseId, time);

        if (verses.isEmpty()) return null;

        return verses;
    }

    // TODO: 08/12/22
//    public List<Verse> getAllVerseBySurahId(Integer id, Instant time) {
//        List<Verse> verses = verseRepository.findAllBySurahIdAndUpdatedDateAfter(id, time);
//
//        if (verses.isEmpty()) return Collections.emptyList();
//
//        return verses;
//    }

    public void saveToDatabase(Verse verse) {
        try {
            verseRepository.save(verse);
        } catch (Exception e) {
            // TODO: 08/12/22
//            throw new ServerBadRequestException(e.getMessage());
        }
    }
 */