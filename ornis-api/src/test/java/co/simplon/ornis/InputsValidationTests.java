package co.simplon.ornis;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Tests inputs against validation")
public class InputsValidationTests extends BaseMvcTests {

    @DisplayName("Should inputs be not valid")
    @ParameterizedTest
    @CsvFileSource(resources = {
	    "/csv/validation/sign-up-not-valid.csv",
	    "/csv/validation/bird-create-not-valid.csv" }, numLinesToSkip = 1, delimiter = DELIMITER, maxCharsPerColumn = MAX_CHARS_PER_COLUMN)
    void shouldBeNotValid(String method, String path,
	    String tokenName, String json, String field,
	    String error) throws Exception {

	String jsonPath = null;
	if (null != field) {
	    jsonPath = String
		    .format("$.errors.*.%s[*].code", field);
	} else {
	    jsonPath = "$.errors.globals.*.code";
	}
	perform(method, path, tokenName, json)
		.andExpect(status().is(400)).andExpect(
			jsonPath(jsonPath, hasItem(error)));
    }

    @DisplayName("Should inputs be valid")
    @ParameterizedTest
    @CsvFileSource(resources = {
	    "/csv/validation/sign-up-valid.csv",
	    "/csv/validation/bird-create-valid.csv" }, numLinesToSkip = 1, delimiter = DELIMITER, maxCharsPerColumn = MAX_CHARS_PER_COLUMN)
    void shouldBeValid(String method, String path,
	    String tokenName, String json)
	    throws Exception {
	perform(method, path, tokenName, json)
		.andExpect(status().is(not(400)));
    }

}
