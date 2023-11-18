package co.simplon.ornis.dtos.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.ornis.services.UserAccountAuthenticationService;

public class EmailUnicityValidator implements
	ConstraintValidator<EmailUnicity, String> {

    private final UserAccountAuthenticationService service;

    public EmailUnicityValidator(
	    UserAccountAuthenticationService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String email,
	    ConstraintValidatorContext context) {
	if (email != null) {
	    return !this.service.emailAddressExists(email);
	}
	return true;

    }
}
