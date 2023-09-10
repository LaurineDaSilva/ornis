package co.simplon.ornis.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.algorithms.Algorithm;

import co.simplon.ornis.security.AuthenticationHelper;

@Configuration
public class SecurityConfig {

    @Value("${ornis.auth.rounds}")
    private int rounds;
    @Value("${ornis.auth.issuer}")
    private String issuer;
    @Value("${ornis.auth.secret")
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
		.passwordEncoder(encoder)
		.expiration(tokenExpiration).build();
    }

}
