package co.simplon.ornis.errors;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {

    private HttpStatus status;
    private List<String> errorCodes;

    public ApiError(HttpStatus status,
	    List<String> errorCodes) {
	super();
	this.status = status;
	this.errorCodes = errorCodes;
    }

    public ApiError(HttpStatus status, String errorCode) {
	super();
	this.status = status;
	errorCodes = Arrays.asList(errorCode);
    }

    public HttpStatus getStatus() {
	return status;
    }

    public List<String> getErrorCodes() {
	return errorCodes;
    }

}
