package co.simplon.ornis.dtos.birds.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = CommonNameUnicityValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CommonNameUnicity {

    String message() default "{ornis.validation.constraints.CommonNameUnicity.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
