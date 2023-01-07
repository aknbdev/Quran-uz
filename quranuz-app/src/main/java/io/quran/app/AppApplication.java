package io.quran.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static io.quran.app.config.ProjectConfig.*;

@SpringBootApplication(scanBasePackages = {BASE_PACKAGE})
@EnableJpaRepositories(basePackages = {REPOSITORY_PACKAGE})
@EntityScan(basePackages = {ENTITY_PACKAGE})
@EnableTransactionManagement
@EnableJpaAuditing
@EnableAsync
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}