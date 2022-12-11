package io.quran.app;

import io.quran.app.config.Project;
import io.quran.app.utils.QuranAPI;
import io.quran.db.entity.Language;
import io.quran.db.entity.Location;
import io.quran.db.entity.SeparatorText;
import io.quran.db.repository.LanguageRepository;
import io.quran.db.repository.LocationRepository;
import io.quran.db.repository.SeparatorTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication(scanBasePackages = {Project.BASE_PACKAGE})
@EnableJpaRepositories(basePackages = {Project.REPOSITORY_PACKAGE})
@EntityScan(basePackages = {Project.ENTITY_PACKAGE})
@EnableTransactionManagement
@EnableJpaAuditing
@EnableAsync
@RequiredArgsConstructor
public class AppApplication implements CommandLineRunner{

    private final QuranAPI quranAPI;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        quranAPI.getSurahInfos();

    }
}
