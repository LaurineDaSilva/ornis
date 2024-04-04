package co.simplon.ornis.dtos.users.validators;

import co.simplon.ornis.services.UserAccountAuthenticationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameUnicityValidator implements
	ConstraintValidator<UsernameUnicity, String> {

    private final UserAccountAuthenticationService service;

    public UsernameUnicityValidator(
	    UserAccountAuthenticationService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String username,
	    ConstraintValidatorContext context) {
	if (username != null) {
	    return !this.service.usernameExists(username);
	}
	return true;

    }

}
