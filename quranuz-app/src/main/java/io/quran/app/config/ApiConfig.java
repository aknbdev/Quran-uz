package io.quran.app.config;

public interface ApiConfig {

    String BASE_API = "/api/v1";

    String USER_API = BASE_API + "/user";

    String SURAH_API = BASE_API + "/surah";
    String VERSE_API = BASE_API + "/verse";
    String VERSE_DETAIL_API = BASE_API + "/verse-detail";
    String LANGUAGE_API = BASE_API + "/language";
    String JUZ_API = BASE_API + "/juz";
    String AUTHOR_API = BASE_API + "/author";
}