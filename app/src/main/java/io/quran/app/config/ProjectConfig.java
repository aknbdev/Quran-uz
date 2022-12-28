package io.quran.app.config;

public interface ProjectConfig {

    String BASE_PACKAGE = "io.quran";

    String REPOSITORY_PACKAGE = BASE_PACKAGE + ".*.repository";
    String ENTITY_PACKAGE = BASE_PACKAGE + ".*.entity";

    String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    String LOCAL_DATE_PATTERN = "yyyy-MM-dd";
}
