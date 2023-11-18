package co.simplon.ornis.dtos.birds.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.ornis.services.BirdService;

public class CommonNameUnicityValidator implements
	ConstraintValidator<CommonNameUnicity, String> {
    private final BirdService service;

    public CommonNameUnicityValidator(BirdService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String commonName,
	    ConstraintValidatorContext context) {
	if (commonName != null) {
	    return !this.service
		    .commonNameExists(commonName);
	}
	return true;

    }

}
