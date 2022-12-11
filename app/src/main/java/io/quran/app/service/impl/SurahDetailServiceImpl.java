package io.quran.app.service.impl;

import io.quran.app.mapper.SurahDetailMapper;
import io.quran.app.payload.ApiResult;
import io.quran.app.payload.SurahDetailDto;
import io.quran.app.service.SurahDetailService;
import io.quran.db.entity.SurahDetail;
import io.quran.db.repository.SurahDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SurahDetailServiceImpl implements SurahDetailService {

    private final SurahDetailRepository surahDetailRepository;
    private final SurahDetailMapper mapper;

    public SurahDetailServiceImpl(SurahDetailRepository surahDetailRepository, SurahDetailMapper mapper) {
        this.surahDetailRepository = surahDetailRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public ApiResult<SurahDetailDto> getSurahDetailById(Integer surahId, Integer languageId){
        SurahDetail surahDetail = getEntity(surahId, languageId);
        return ApiResult.successResponse(mapper.toDto(surahDetail));
    }

    public SurahDetail getEntity(Integer surahId, Integer languageId){
        Optional<SurahDetail> optional = surahDetailRepository.findBySurahIdAndLanguageId(surahId, languageId);
        return optional.isPresent() ? optional.get() : null;
    }
}
