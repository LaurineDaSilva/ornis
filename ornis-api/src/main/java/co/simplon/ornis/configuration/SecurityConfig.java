package co.simplon.ornis.configuration;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import com.auth0.jwt.algorithms.Algorithm;

import co.simplon.ornis.authentication.AuthenticationHelper;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Value("${ornis.auth.rounds}")
    private int rounds;
    @Value("${ornis.auth.issuer}")
    private String issuer;
    @Value("${ornis.auth.secret}")
    private String secret;
    @Value("${ornis.auth.tokenExpiration}")
    private long tokenExpiration;

    @Bean
    public AuthenticationHelper authenticationHelper() {
	Algorithm algorithm = Algorithm.HMAC256(secret);
	PasswordEncoder encoder = new BCryptPasswordEncoder(
		rounds);
	return new AuthenticationHelper.Builder()
		.algorithm(algorithm)
		.passwordEncoder(encoder).issuer(issuer)
		.expiration(tokenExpiration).build();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)
	    throws Exception {
	http.cors(Customizer.withDefaults())
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(
			authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
				.requestMatchers(
					"/birds/list",
					"/birds/{id}/detail",
					"/birds/search",
					"/birds/filter",
					"/beakShapes",
					"/feetShapes",
					"/sizes", "/colors")
				.permitAll()
				.requestMatchers(
					"/join/sign-in",
					"/join/sign-up")
				.anonymous()
				.requestMatchers(
					HttpMethod.DELETE)
				.hasRole("ADMIN")
				.requestMatchers(
					"/birds/create",
					"/birds/{id}/to-update",
					"/birds/update/{id}",
					"/birds/delete/{id}")
				.hasRole("ADMIN")
				.anyRequest()
				.authenticated())
		.oauth2ResourceServer((
			oauth2ResourceServer) -> oauth2ResourceServer
				.jwt(Customizer
					.withDefaults()));

	return http.build();
    }

    @Bean
    JwtAuthenticationConverter authenticationConverter() {
	JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
	authoritiesConverter
		.setAuthoritiesClaimName("roles");
	authoritiesConverter.setAuthorityPrefix("");
	JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
	authenticationConverter
		.setJwtGrantedAuthoritiesConverter(
			authoritiesConverter);
	return authenticationConverter;
    }

    @Bean
    JwtDecoder jwtDecoder() throws Exception {
	SecretKeySpec key = new SecretKeySpec(
		secret.getBytes(), "HmacSHA256");
	return NimbusJwtDecoder.withSecretKey(key).build();
    }

}
