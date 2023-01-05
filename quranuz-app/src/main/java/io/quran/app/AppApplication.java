package io.quran.app;

import io.quran.app.config.ProjectConfig;
import io.quran.app.utils.QuranAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {ProjectConfig.BASE_PACKAGE})
@EnableJpaRepositories(basePackages = {ProjectConfig.REPOSITORY_PACKAGE})
@EntityScan(basePackages = {ProjectConfig.ENTITY_PACKAGE})
@EnableTransactionManagement
@EnableJpaAuditing
@EnableAsync
@RequiredArgsConstructor
public class AppApplication implements CommandLineRunner {

    private final QuranAPI quranAPI;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        quranAPI.saveJuz();
    }
}