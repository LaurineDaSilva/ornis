package co.simplon.ornis.dtos.users.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = UsernameUnicityValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameUnicity {

    String message() default "{ornis.validation.constraints.UsernameUnicity.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
