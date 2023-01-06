package io.quran.app.service.impl;

import io.quran.app.mapper.JuzMapper;
import io.quran.app.payload.api.ApiResult;
import io.quran.app.payload.juz.JuzDto;
import io.quran.app.payload.juz.JuzSurahDto;
import io.quran.app.payload.surah.SurahWithName;
import io.quran.app.service.JuzService;
import io.quran.db.entity.Juz;
import io.quran.db.repository.JuzRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

        juzs.forEach(juz -> {
            JuzSurahDto dto = new JuzSurahDto();
            dto.setSurahWithName(surahs.get(juz.getSurahOrderNumber() - 1));

            String[] arr = juz.getVersesOrderNumber().split("-");

            dto.setStartOrderNumber(Integer.valueOf(arr[0]));
            dto.setEndOrderNumber(Integer.valueOf(arr[1]));

            if(!juzSurahsDto.containsKey(juz.getJuzNumber())){
                juzSurahsDto.put(juz.getJuzNumber(), new JuzDto(juz.getJuzNumber(), new ArrayList<>()));
            }
            JuzDto juzDto = juzSurahsDto.get(juz.getJuzNumber());
            juzDto.getSurahs().add(dto);
            juzSurahsDto.put(juz.getJuzNumber(), juzDto);
        });

        return ApiResult.successResponse(juzSurahsDto.values());
    }
}
