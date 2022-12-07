package io.quran.app.service.impl;

import io.quran.db.entity.Surah;
import io.quran.app.mapper.SurahMapper;
import io.quran.app.payload.ApiResult;
import io.quran.app.payload.SurahDto;
import io.quran.db.repository.SurahRepository;
import io.quran.app.service.SurahService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SurahServiceImpl implements SurahService {

    private final SurahRepository surahRepository;
    private final SurahMapper surahMapper;

    public SurahServiceImpl(SurahRepository surahRepository, SurahMapper surahMapper) {
        this.surahRepository = surahRepository;
        this.surahMapper = surahMapper;
    }

    @Override
    public ApiResult<SurahDto> getSurahById(Integer id) {
        Surah surah = getEntity(id);
        return surah != null ? ApiResult.successResponse(surahMapper.toDto(surah)) : null;
    }


    // =========== SECONDARY FUNCTIONS =========== //
    public Surah getEntity(Integer surahId){
        Optional<Surah> optionalSurah = surahRepository.findById(surahId);
        return optionalSurah.isPresent() ? optionalSurah.get() : null;
    }
}
