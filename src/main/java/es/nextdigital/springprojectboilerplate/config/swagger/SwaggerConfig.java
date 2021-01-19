package es.nextdigital.springprojectboilerplate.config.swagger;

import es.nextdigital.springprojectboilerplate.config.AppProfiles;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.apache.commons.lang3.StringUtils;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Clase de configuración para los docs
 * automatizados con Swagger de la API
 */
@Configuration
@Profile(AppProfiles.SWAGGER)
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Spring Project Boilerplate API")
                                .description(
                                        "Next Digital Hub - Spring Project Boilerplate - Endpoints")
                );
    }

    @Bean
    public OpenApiCustomiser sortTagsAlphabetically() {
        return openApi -> openApi.setTags(openApi.getTags()
                .stream()
                .sorted(Comparator.comparing(tag -> StringUtils.stripAccents(tag.getName())))
                .collect(Collectors.toList()));
    }
}
