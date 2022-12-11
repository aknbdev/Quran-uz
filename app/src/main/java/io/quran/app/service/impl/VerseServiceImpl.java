package io.quran.app.service.impl;

import io.quran.app.payload.VerseDto;
import io.quran.app.service.VerseService;
import io.quran.db.entity.Verse;
import io.quran.db.repository.VerseDetailRepository;
import io.quran.db.repository.VerseRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

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
    public void createVerse(VerseDto dto) {
        Verse verse = dtoToVerse(dto);
        // TODO: 08/12/22
//        verse.setUpdatedAt(Instant.now());
        saveToDatabase(verse);
    }

    @Override
    public void updateVerse(Integer id, VerseDto dto) {
        Verse newVerse = dtoToVerse(dto);
        newVerse.setId(id);
        // TODO: 08/12/22
//        newVerse.setUpdatedAt(Instant.now());
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

    public Verse dtoToVerse(VerseDto dto) {
        Verse verse = new Verse();

        verse.setId(dto.getVerseId());
        verse.setSurahId(dto.getSurahId());
        verse.setVerseText(dto.getVerseText());
        verse.setOrderNumber(dto.getOrder_number());
        verse.setJuzId(dto.getJuzId());
        // TODO: 08/12/22
//        verse.setUpdatedAt(TimeConverter.convertToLocalDateTime(dto.getMilliseconds()));
        return verse;
    }

    public VerseDto verseToDto(Verse verse) {
        VerseDto dto = new VerseDto();

        dto.setVerseId(verse.getId());
        // TODO: 08/12/22
//        dto.setSurahDto(surahService.entityToDto(verse.getSurah(), new SurahDto()));
        dto.setSurahId(verse.getSurahId());
        dto.setVerseText(verse.getVerseText());
        dto.setOrder_number(verse.getOrderNumber());
        dto.setJuzId(verse.getJuzId());
        // TODO: 08/12/22
//        dto.setMilliseconds(TimeConverter.convertMilliseconds(verse.getUpdatedDate()));
        return dto;
    }
}


// |->  DEPRECATED THINGS   <-|


//    public List<ParaDto> verseToJuzDto(List<Verse> verse, Long millisecond) {
//
//        int[] surahIdS = new int[30];
//
//        for (int i = 0; i < 30; i++) {
//            surahIdS[i] = verse.get(i).getSurahId();
//        }
//
//        Map<Integer, SurahDetail> surahDetailMap = new HashMap<>();
//
//        surahDetailService.getAllSurahDetailsBySurahIdListAndLanguageId(surahIdS, millisecond, 1)
//                .forEach(surahDetail -> surahDetailMap.put(surahDetail.getSurahId(), surahDetail));
//
//        List<ParaDto> paraDtoList = new ArrayList<>();
//
//        verse.forEach(
//                verse1 -> paraDtoList.add(
//                        new ParaDto(
//                                verse1.getJuzId(),
//                                surahDetailMap.get(verse1.getSurahId()).getSurahName(),
//                                verse1.getOrderNumber()
//                        )
//                )
//        );
//
//        return paraDtoList;
//    }

//    @Override
//    public List<ParaDto> getAllVerseByJuz(long millisecond) {
//
//        return verseToJuzDto(getAllByJuz(TimeConverter.convertToLocalDateTime(millisecond)), millisecond);
//    }

//        return verses.stream().map(this::verseToDto).collect(Collectors.toList());


//    @Override
//    public VerseDto getByVerseId(Integer verseId,
//                                 Integer languageId,
//                                 long millisecond) {
//
//        Optional<Verse> optionalVerse = verseRepository
//                .findByVerseIdAndUpdatedDateAfter(
//                        verseId,
//                        TimeConverter.convertToLocalDateTime(millisecond)
//                );
//        if (optionalVerse.isEmpty()){
//            return null;
//        }
//
//        String translation = verseDetailRepository.getVerseTranslation(languageId, optionalVerse.get().getVerseId());
//
//        return verseToDto(optionalVerse.get());
//    }
//    public Verse getVerse(Integer id, Instant time) {
//        return ;
//    }
//            throw new ServerBadRequestException("Verse not found!"));
//            throw new ServerBadRequestException("Verses not found!");
//            throw new ServerBadRequestException("Verses not found!");

//        dto.setJuzId(verse.getJuzId());
//        dto.setVerseOrderNumber(verse.getOrder_number());
//        dto.setSurahName(surahDetailService.getBySurahIdAndTime(verse.getSurahId(), 0).getSurahName());

//        return getAllByJuz(TimeConverter.convertToLocalDateTime(millisecond))
//                .stream()
//                .map(this::verseToJuzDto)
//                .collect(Collectors.toList());


//        for (int i = 1; i <= 30; i++) {
//            if (verseRepository.getFirstByJuzId(i, time).isPresent()) {
//                verses.add(verseRepository.getFirstByJuzId(i, time).get());
//            }
//        }

//    public Verse getEntityByJuzId(Integer juzId, Instant time) {
//        return verseRepository.getFirstByJuzId(juzId, time).orElse(null);
//    }