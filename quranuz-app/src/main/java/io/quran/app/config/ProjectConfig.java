package io.quran.app.config;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public abstract class ProjectConfig {

    public static final String PROJECT_NAME = "Quran Uz";
    public static final String BASE_PACKAGE = "io.quran";
    public static final String REPOSITORY_PACKAGE = BASE_PACKAGE + ".*.repository";
    public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".*.entity";
    public static final String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String LOCAL_DATE_PATTERN = "yyyy-MM-dd";
}
