package io.quran.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Quran Uz backend docs",
        version = "0.0.1",
        contact = @Contact(name = "idea one", url = "idea-one.is-a.dev"),
        license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0")),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local server"),
                @Server(url = "https://quranuz-backend.up.railway.app")})
@SecurityScheme(scheme = "bearer",
        name = ProjectConfig.PROJECT_NAME,
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER)
public class DocConfig {
}