package co.simplon.ornis.dtos.birds.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.ornis.services.BirdService;

public class ScientificNameUnicityValidator implements
	ConstraintValidator<ScientificNameUnicity, String> {

    private final BirdService service;

    public ScientificNameUnicityValidator(
	    BirdService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String scientificName,
	    ConstraintValidatorContext context) {
	if (scientificName != null) {
	    return !this.service
		    .scientificNameExists(scientificName);
	}
	return true;

    }

}
