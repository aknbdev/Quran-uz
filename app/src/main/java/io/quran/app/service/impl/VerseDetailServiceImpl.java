package io.quran.app.service.impl;

import io.quran.app.payload.VerseDetailDto;
import io.quran.app.service.VerseDetailService;
import io.quran.db.entity.VerseDetail;
import io.quran.db.repository.VerseDetailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public VerseDetailDto getOneBySurahIdVerseId(Integer surahId,
                                                 Integer verseId,
                                                 Integer languageId,
                                                 long millisecond) {

        Optional<VerseDetail> verseDetail = null;
        // TODO: 08/12/22
//                verseDetailRepository.findBySurahIdAndVerseIdAndUpdatedDateAfter(
//                        surahId,
//                        verseId,
//                        languageId,
//                        TimeConverter.convertToLocalDateTime(millisecond)
//                );

        return verseDetail.isEmpty() ? null : verseDetailToDto(verseDetail.get());
    }

    @Override
    public List<VerseDetailDto> getVerseDetailBySurahId(Integer surahId,
                                                        Integer languageId,
                                                        long millisecond) {

        List<VerseDetail> verseDetails = null;
        // TODO: 08/12/22
//                verseDetailRepository
//                .findAllBySurahIdAndUpdatedDateAfter(surahId, languageId, TimeConverter.convertToLocalDateTime(millisecond));

        if (verseDetails.isEmpty()) {
            return new ArrayList<>();
        }

        return verseDetails.stream().map(this::verseDetailToDto).collect(Collectors.toList());
    }

    @Override
    public List<VerseDetailDto> getAllVerseDetail(Integer languageId, long millisecond) {
        List<VerseDetail> allVerseDetail = null;
        // TODO: 08/12/22
//                verseDetailRepository.findAllByUpdatedDateAfter(
//                        languageId,
//                        TimeConverter.convertToLocalDateTime(millisecond)
//                );
        if (allVerseDetail.isEmpty()) return Collections.emptyList();

        return allVerseDetail
                .stream()
                .map(this::verseDetailToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createVerseDetail(VerseDetailDto dto) {
        VerseDetail entity = dtoToVerseDetail(dto);
        // TODO: 08/12/22
//        entity.setUpdatedAt(Instant.now());
        verseDetailRepository.save(entity);
    }

    @Override
    public void updateVerseDetail(Integer id, VerseDetailDto dto) {
        VerseDetail entity = dtoToVerseDetail(dto);
        entity.setId(id);
        // TODO: 08/12/22
//        entity.setUpdatedAt(Instant.now());
        verseDetailRepository.save(entity);
    }

    // |- SECONDARY FUNCTIONS -|

    public VerseDetail dtoToVerseDetail(VerseDetailDto dto) {
        VerseDetail entity = new VerseDetail();

        entity.setId(dto.getVerseDetailId());
        entity.setVerseId(dto.getVerseId());
        entity.setLanguageId(dto.getLanguageId());
        entity.setTranscript(dto.getTranscript());
        entity.setTranslation(dto.getTranslation());
        entity.setDescription(dto.getDescription());
        entity.setSurahId(dto.getSurahId());
        // TODO: 08/12/22
//        entity.setUpdatedAt(TimeConverter.convertToLocalDateTime(dto.getMilliseconds()));
        return entity;
    }

    public VerseDetailDto verseDetailToDto(VerseDetail entity) {
        VerseDetailDto dto = new VerseDetailDto();

        dto.setVerseDetailId(entity.getVerseId());
        dto.setVerseDto(verseService.verseToDto(entity.getVerse()));
        dto.setVerseId(entity.getVerseId());
        dto.setSurahId(entity.getSurahId());
        dto.setLanguageDto(languageService.entityToDto(entity.getLanguage()));
        dto.setLanguageId(entity.getLanguageId());
        dto.setTranscript(entity.getTranscript());
        dto.setTranslation(entity.getTranslation());
        dto.setDescription(entity.getDescription());
        // TODO: 08/12/22
//        dto.setMilliseconds(TimeConverter.convertMilliseconds(entity.getUpdatedDate()));
        return dto;
    }
}


// DEPRECATED THINGS
//public List<VerseDetail> findAllVerseDetail(Instant time) {
//    List<VerseDetail> verseDetails = verseDetailRepository.findAllByUpdatedDateAfter(time);
//    if (verseDetails.isEmpty()) return Collections.emptyList();
//
//    return verseDetails;
//}
//              throw new ServerBadRequestException("Verse Detail not found!"));
//              throw new ServerBadRequestException("Verse Details not Found!");
