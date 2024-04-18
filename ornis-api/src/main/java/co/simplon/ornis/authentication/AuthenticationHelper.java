package co.simplon.ornis.authentication;

import java.time.Instant;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class AuthenticationHelper {

    private final String issuer;

    private final long expiration;

    private final Algorithm algorithm;

    private final PasswordEncoder encoder;

    public AuthenticationHelper(Builder builder) {
	this.issuer = builder.issuer;
	this.algorithm = builder.algorithm;
	this.encoder = builder.passwordEncoder;
	this.expiration = builder.expiration;
    }

    public String encode(String password) {
	return encoder.encode(password);
    }

    public Boolean matches(String candidate, String hash) {
	return encoder.matches(candidate, hash);
    }

    public String createJWT(String role, String name) {
	Instant now = Instant.now();

	Instant expirationTime = now
		.plusSeconds(expiration);

	return JWT.create().withIssuer(issuer)
		.withSubject(name).withIssuedAt(now)
		.withExpiresAt(expirationTime)
		.withClaim("roles", role).sign(algorithm);
    }

    public static class Builder {
	private String issuer;

	private long expiration;

	private Algorithm algorithm;

	private PasswordEncoder passwordEncoder;

	public Builder() {

	}

	public Builder issuer(String issuer) {
	    this.issuer = issuer;
	    return this;
	}

	public Builder expiration(long expiration) {
	    this.expiration = expiration;
	    return this;
	}

	public Builder algorithm(Algorithm algorithm) {
	    this.algorithm = algorithm;
	    return this;
	}

	public Builder passwordEncoder(
		PasswordEncoder passwordEncoder) {
	    this.passwordEncoder = passwordEncoder;
	    return this;
	}

	public AuthenticationHelper build() {
	    return new AuthenticationHelper(this);
	}

    }

}
