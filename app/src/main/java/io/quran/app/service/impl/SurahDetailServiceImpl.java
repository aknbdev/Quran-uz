package io.quran.app.service.impl;

import io.quran.app.mapper.SurahDetailMapper;
import io.quran.app.payload.api.ApiResult;
import io.quran.app.payload.surah.SurahDetailDto;
import io.quran.app.payload.surah.SurahWithName;
import io.quran.app.service.LanguageService;
import io.quran.app.service.SurahDetailService;
import io.quran.db.entity.SurahDetail;
import io.quran.db.repository.SurahDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurahDetailServiceImpl implements SurahDetailService {

    private final SurahDetailRepository surahDetailRepository;
    private final SurahDetailMapper mapper;
    private final LanguageService languageService;

    @Transactional(readOnly = true)
    public ApiResult<SurahDetailDto> getSurahDetailById(Integer surahId, Integer languageId){
        SurahDetail surahDetail = getEntity(surahId, languageId);
        return ApiResult.successResponse(mapper.toDto(surahDetail));
    }

    @Override
    public ApiResult<?> getSurahs(Integer languageId) {
        List<SurahWithName> surahWithNames = new ArrayList<>();
        List<SurahDetail> surahDetailList = getAllEntity(languageId);

        if(surahDetailList == null || surahDetailList.isEmpty())
            return ApiResult.errorResponse("Surahs not found with this code", 404);

        for (SurahDetail surahDetail : surahDetailList) {
            SurahWithName surah = new SurahWithName();
            surah.setArabicName(surahDetail.getSurah().getName());
            surah.setName(surahDetail.getSurahName());
            surah.setOrderNumber(surahDetail.getSurah().getOrderNumber());
            surah.setVerseCount(surahDetail.getSurah().getVerseCount());

            surahWithNames.add(surah);
        }

        return ApiResult.successResponse(surahWithNames);
    }

    public SurahDetail getEntity(Integer surahId, Integer languageId){
        Optional<SurahDetail> optional = surahDetailRepository.findBySurahIdAndLanguageId(surahId, languageId);
        return optional.orElse(null);
    }

    public List<SurahDetail> getAllEntity(Integer languageId){
//        Integer languageId = languageService.getLanguageIdByCode(languageCode);
//        log.info("Language id => {}", languageId);
        List<SurahDetail> surahDetailList = surahDetailRepository.findAllByLanguageId(languageId);
        return !surahDetailList.isEmpty() ? surahDetailList : null;
    }
}


// FOR SAVING DATA FROM API

//    @Override
//    public void saveSurahDetail(Surah surah, String surahName, Integer languageId, Integer locationId, Integer separatorTextId) {
//        SurahDetail surahDetail = new SurahDetail();
//        surahDetail.setSurahId(surah.getId());
//        surahDetail.setLanguageId(languageId);
//        surahDetail.setLocationId(locationId);
//        surahDetail.setSeparatorTextId(separatorTextId);
//        surahDetail.setSurahName(surahName);
//
//        surahDetailRepository.save(surahDetail);
//    }
