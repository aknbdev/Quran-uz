package io.quran.app.service.impl;

import io.quran.core.response.ApiResult;
import io.quran.db.entity.Surah;
import io.quran.app.mapper.SurahMapper;
import io.quran.app.payload.surah.SurahDto;
import io.quran.db.repository.SurahRepository;
import io.quran.app.service.SurahService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SurahServiceImpl implements SurahService {

    private final SurahRepository surahRepository;
    private final SurahMapper surahMapper;

    public SurahServiceImpl(SurahRepository surahRepository, SurahMapper surahMapper) {
        this.surahRepository = surahRepository;
        this.surahMapper = surahMapper;
    }

    @Override
    public ApiResult<SurahDto> getSurahById(Integer id, Integer languageId) {
        Surah surah = getEntity(id, languageId);
        return surah != null ? ApiResult.successResponse(surahMapper.toDto(surah)) : null;
    }

    @Override
    public ApiResult<?> getAllSurahs() {
        List<Surah> surahList = surahRepository.findAll();

        if (surahList.isEmpty())
            return ApiResult.errorResponse("Data not found", 400);

        return ApiResult.successResponse(surahMapper.toEntityList(surahList));
    }

    @Override
    public Surah saveSurah(SurahDto surahDto) {
        Surah surah = surahMapper.toEntity(surahDto);
        log.info("Surah -> {}", surah);
        return surahRepository.save(surahMapper.toEntity(surahDto));
//        return null;
    }


    // =========== SECONDARY FUNCTIONS =========== //
    public Surah getEntity(Integer surahId, Integer languageId){
        Optional<Surah> optionalSurah = surahRepository.findById(surahId);
        return optionalSurah.isPresent() ? optionalSurah.get() : null;
    }
}
