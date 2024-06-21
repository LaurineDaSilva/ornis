package co.simplon.ornis.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnProperty(value = "ornis.cors.enabled", havingValue = "true", matchIfMissing = true)
public class WebConfig implements WebMvcConfigurer {

    @Value("${ornis.cors.allowedOrigins}")
    private String[] allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
		.allowedOrigins(allowedOrigins)
		.allowedMethods("GET", "POST", "PUT",
			"DELETE", "PATCH");
    }

}
