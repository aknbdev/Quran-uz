package io.quran.app.service;


import io.quran.app.payload.verse.VerseSaveDto;

import java.util.List;

public interface VerseService {

    List<VerseSaveDto> getAllBySurahId(Integer id, String lang);

    List<VerseSaveDto> getAllByJuzId(Integer juzId, String lang);
}