package io.quran.app.service.impl;

import io.quran.app.mapper.JuzMapper;
import io.quran.app.payload.juz.JuzDto;
import io.quran.app.payload.juz.JuzSurahDto;
import io.quran.app.payload.surah.SurahWithName;
import io.quran.app.service.JuzService;
import io.quran.core.exception.RestException;
import io.quran.core.response.ApiResult;
import io.quran.db.entity.Juz;
import io.quran.db.repository.JuzRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class JuzServiceImpl implements JuzService {

    private final JuzRepository juzRepository;
    private final JuzMapper juzMapper;
    private final SurahDetailServiceImpl surahDetailService;
    private List<SurahWithName> surahs;

    @Override
    public void saveJuz(Juz juz) {
        log.info("saving juz: {}", juz);
//        juzRepository.save(juz);
    }

    @Override
    public ApiResult<Collection<JuzDto>> getAllJuz(Integer languageId) {
        Map<Integer, JuzDto> juzSurahsDto = new HashMap<>();
        List<Juz> juzs = juzRepository.findAll();

        surahs = surahDetailService.getSurahsForApi(languageId);

        if(surahs.isEmpty())
            throw  RestException.restThrow("Juzs", "languageId", languageId, "Juzs with this language not exist !");

        juzs.forEach(juz -> {
            SurahWithName surah = surahs.get(juz.getSurahOrderNumber() - 1);
            JuzSurahDto dto = surahToJuzDto(
                    surah,
                    juz.getVersesOrderNumber().split("-"));

            if(!juzSurahsDto.containsKey(juz.getJuzNumber())){
                juzSurahsDto.put(juz.getJuzNumber(), new JuzDto(juz.getJuzNumber(), new ArrayList<>()));
            }
            JuzDto juzDto = juzSurahsDto.get(juz.getJuzNumber());
            juzDto.getSurahs().add(dto);
            juzSurahsDto.put(juz.getJuzNumber(), juzDto);
        });

        return ApiResult.successResponse(juzSurahsDto.values());
    }

    // ======= SECONDARY FUNCTIONS =======

    private JuzSurahDto surahToJuzDto(SurahWithName surah, String[] arr){
        JuzSurahDto dto = new JuzSurahDto();
        dto.setSurahId(surah.getSurahId());
        dto.setArabicName(surah.getArabicName());
        dto.setSurahName(surah.getName());
        dto.setStartOrderNumber(Integer.valueOf(arr[0]));
        dto.setEndOrderNumber(Integer.valueOf(arr[1]));
        dto.setSurahOrderNumber(surah.getOrderNumber());
        return dto;
    }
}
