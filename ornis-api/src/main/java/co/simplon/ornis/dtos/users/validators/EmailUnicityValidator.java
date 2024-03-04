package co.simplon.ornis.dtos.users.validators;

import co.simplon.ornis.services.UserAccountAuthenticationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

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
