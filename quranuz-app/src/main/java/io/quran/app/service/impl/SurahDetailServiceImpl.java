package io.quran.app.service.impl;

import io.quran.app.mapper.SurahDetailMapper;
import io.quran.app.payload.filter.FilterDto;
import io.quran.app.payload.surah.SurahDetailDto;
import io.quran.app.payload.surah.SurahWithName;
import io.quran.app.service.SurahDetailService;
import io.quran.core.enums.SortType;
import io.quran.core.exception.RestException;
import io.quran.core.response.ApiResult;
import io.quran.db.entity.SurahDetail;
import io.quran.db.repository.SurahDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurahDetailServiceImpl implements SurahDetailService {

    private final SurahDetailRepository surahDetailRepository;
    private final SurahDetailMapper mapper;

    @Transactional(readOnly = true)
    public ApiResult<SurahDetailDto> getSurahDetailById(Integer surahId, Integer languageId) {
        SurahDetail surahDetail = getEntity(surahId, languageId);
        return ApiResult.successResponse(mapper.toDto(surahDetail));
    }

    public ApiResult<?> getSurahs(Integer languageId) {
        List<SurahWithName> surahs = getSurahsForApi(languageId);
        return ApiResult.successResponse(surahs);
    }

    public List<SurahWithName> getSurahsForApi(Integer languageId) {

        List<SurahDetail> surahDetailList = getAllEntity(languageId);

        if (surahDetailList == null || surahDetailList.isEmpty())
            return Collections.emptyList();

        return extractSurah(surahDetailList);
    }

    public ApiResult<List<SurahWithName>> getAllSurahsWithFilter(FilterDto filter, Integer languageId) {
        if (filter.getSortDirection() == null)
            filter.setSortDirection(SortType.ASC.name());

        if(filter.getValue() == null)
            filter.setValue("");

        Sort sort = filter.getSortDirection().equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by("id").ascending()
                : Sort.by("id").descending();

        List<Predicate> predicateList = new LinkedList<>();
        Specification<SurahDetail> specification = ((root, query, criteriaBuilder) -> {

            predicateList.add(
                    criteriaBuilder.equal(
                            root.get("languageId"), languageId)
            );

            predicateList.add(
                    criteriaBuilder.like(criteriaBuilder.lower(
                            root.get("surahName")
                    ), "%" + filter.getValue() + "%")
            );

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        });

        List<SurahDetail> surahDetailList = surahDetailRepository.findAll(specification, sort);

        if(surahDetailList.isEmpty())
            throw RestException.restThrow("Surahs not found with this language id or surah name", HttpStatus.NOT_FOUND);

        List<SurahWithName> surahs = extractSurah(surahDetailList);

        return ApiResult.successResponse(surahs);
    }

    private SurahDetail getEntity(Integer surahId, Integer languageId) {
        Optional<SurahDetail> optional = surahDetailRepository.findBySurahIdAndLanguageId(surahId, languageId);
        return optional.orElse(null);
    }

    private List<SurahDetail> getAllEntity(Integer languageId) {
        List<SurahDetail> surahDetailList = surahDetailRepository.findAllByLanguageIdOrderByIdAsc(languageId);
        return !surahDetailList.isEmpty() ? surahDetailList : null;
    }

    private List<SurahWithName> extractSurah(List<SurahDetail> surahDetailList) {
        return surahDetailList.stream()
                .map(surahDetail -> {
                    SurahWithName surah = new SurahWithName();
                    surah.setSurahId(surahDetail.getId());
                    surah.setArabicName(surahDetail.getSurah().getName());
                    surah.setName(surahDetail.getSurahName());
                    surah.setOrderNumber(surahDetail.getSurah().getOrderNumber());
                    surah.setVerseCount(surahDetail.getSurah().getVerseCount());
                    return surah;
                })
                .collect(Collectors.toList());
    }
}

//        for (SurahDetail surahDetail : surahDetailList) {
//            SurahWithName surah = new SurahWithName();
//            surah.setSurahId(surahDetail.getId());
//            surah.setArabicName(surahDetail.getSurah().getName());
//            surah.setName(surahDetail.getSurahName());
//            surah.setOrderNumber(surahDetail.getSurah().getOrderNumber());
//            surah.setVerseCount(surahDetail.getSurah().getVerseCount());
//
//            surahWithNames.add(surah);
//        }
//
//        return surahWithNames;
