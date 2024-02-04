package co.simplon.ornis.dtos.birds.validators;

import co.simplon.ornis.services.BirdService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

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
