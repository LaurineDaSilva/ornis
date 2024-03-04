package co.simplon.ornis.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomRestExceptionHandler
	extends ResponseEntityExceptionHandler {

    /**
     * This method handles scenarios of a client sending an invalid request to the
     * API - BindException is thrown when fatal binding errors occur -
     * MethodArgumentNotValidException is thrown when an argument annotated
     * with @Valid failed validation
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex,
	    HttpHeaders headers, HttpStatusCode status,
	    WebRequest request) {
	List<String> errorCodes = new ArrayList<>();
	for (FieldError errorCode : ex.getBindingResult()
		.getFieldErrors()) {
	    errorCodes.add(errorCode.getField() + ": "
		    + errorCode.getDefaultMessage());
	}

	ApiError apiError = new ApiError(
		HttpStatus.BAD_REQUEST, errorCodes);
	return handleExceptionInternal(ex, apiError,
		headers, apiError.getStatus(), request);
    }
}
