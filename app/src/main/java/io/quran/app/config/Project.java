package io.quran.app.config;

public interface Project {

    String BASE_PACKAGE = "io.quran";

    String REPOSITORY_PACKAGE = BASE_PACKAGE + ".*.repository";
    String ENTITY_PACKAGE = BASE_PACKAGE + ".*.entity";
}
