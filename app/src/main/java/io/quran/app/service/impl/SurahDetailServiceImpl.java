package io.quran.app.service.impl;

import io.quran.app.mapper.SurahDetailMapper;
import io.quran.app.payload.api.ApiResult;
import io.quran.app.payload.SurahDetailDto;
import io.quran.app.service.SurahDetailService;
import io.quran.db.entity.Surah;
import io.quran.db.entity.SurahDetail;
import io.quran.db.repository.SurahDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class SurahDetailServiceImpl implements SurahDetailService {

    private final SurahDetailRepository surahDetailRepository;
    private final SurahDetailMapper mapper;

    public SurahDetailServiceImpl(SurahDetailRepository surahDetailRepository, SurahDetailMapper surahDetailMapper) {
        this.surahDetailRepository = surahDetailRepository;
        this.mapper = surahDetailMapper;
    }

    @Transactional(readOnly = true)
    public ApiResult<SurahDetailDto> getSurahDetailById(Integer surahId, Integer languageId){
        SurahDetail surahDetail = getEntity(surahId, languageId);
        return ApiResult.successResponse(mapper.toDto(surahDetail));
    }

    @Override
    public void saveSurahDetail(Surah surah, String surahName, Integer languageId, Integer locationId, Integer separatorTextId) {
        SurahDetail surahDetail = new SurahDetail();
        surahDetail.setSurahId(surah.getId());
        surahDetail.setLanguageId(languageId);
        surahDetail.setLocationId(locationId);
        surahDetail.setSeparatorTextId(separatorTextId);
        surahDetail.setSurahName(surahName);

        surahDetailRepository.save(surahDetail);
    }

    public SurahDetail getEntity(Integer surahId, Integer languageId){
        Optional<SurahDetail> optional = surahDetailRepository.findBySurahIdAndLanguageId(surahId, languageId);
        return optional.isPresent() ? optional.get() : null;
    }
}
