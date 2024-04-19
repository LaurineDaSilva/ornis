package co.simplon.ornis.dtos.birds.validators;

import co.simplon.ornis.services.BirdService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class XenoIdUnicityValidator implements
	ConstraintValidator<XenoIdUnicity, Integer> {

    private final BirdService service;

    public XenoIdUnicityValidator(BirdService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(Integer xenoId,
	    ConstraintValidatorContext context) {
	if (xenoId != null) {
	    return !this.service.xenoIdExists(xenoId);
	}
	return true;

    }

}
