package co.simplon.ornis.dtos.users.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.ornis.services.UserAccountAuthenticationService;

public class NicknameUnicityValidator implements
	ConstraintValidator<NicknameUnicity, String> {

    private final UserAccountAuthenticationService service;

    public NicknameUnicityValidator(
	    UserAccountAuthenticationService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String nickname,
	    ConstraintValidatorContext context) {
	if (nickname != null) {
	    return !this.service.nicknameExists(nickname);
	}
	return true;

    }

}
