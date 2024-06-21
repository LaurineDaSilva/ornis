package co.simplon.ornis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Tokens {

    @Value("${ornis.tests.fake-token}")
    private String fake;

    @Value("${ornis.tests.bad-secret-token}")
    private String badSecret;

    @Value("${ornis.tests.bad-issuer-token}")
    private String badIssuer;

    @Value("${ornis.tests.expired-token}")
    private String expired;

    @Value("${ornis.tests.valid-admin-token}")
    private String admin;

    @Value("${ornis.tests.valid-user-token}")
    private String user;

    String get(final String name) {
	switch (name) {
	case "fake":
	    return fake;
	case "badSecret":
	    return badSecret;
	case "badIssuer":
	    return badIssuer;
	case "expired":
	    return expired;
	case "admin":
	    return admin;
	case "user":
	    return user;
	default:
	    throw new IllegalArgumentException(
		    "Unexpected value: " + name);
	}
    }

}