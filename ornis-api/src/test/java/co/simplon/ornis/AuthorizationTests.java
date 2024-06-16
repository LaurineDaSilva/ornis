package co.simplon.ornis;

import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Tests endpoints against authorization")
class AuthorizationTests extends BaseMvcTests {

    @DisplayName("Should access be denied")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/auth/denied.csv", numLinesToSkip = 1, delimiter = DELIMITER, maxCharsPerColumn = MAX_CHARS_PER_COLUMN)
    void shouldBeDenied(String method, String path,
	    String tokenName, int expectedStatus)
	    throws Exception {
	perform(method, path, tokenName)
		.andExpect(status().is(expectedStatus));
    }

    @DisplayName("Should access be authorized")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/auth/authorized.csv", numLinesToSkip = 1, delimiter = DELIMITER, maxCharsPerColumn = MAX_CHARS_PER_COLUMN)
    void shouldBeAuthorized(String method, String path,
	    String tokenName) throws Exception {
	perform(method, path, tokenName).andExpectAll(
		status().is(not(401)),
		status().is(not(403)));
    }

}
