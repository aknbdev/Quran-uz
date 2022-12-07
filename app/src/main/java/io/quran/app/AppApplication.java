package io.quran.app;

import io.quran.app.config.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {Project.BASE_PACKAGE})
@EnableJpaRepositories(basePackages = {Project.REPOSITORY_PACKAGE})
@EntityScan(basePackages = {Project.ENTITY_PACKAGE})
@EnableTransactionManagement
@EnableJpaAuditing
@EnableAsync
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
