package co.simplon.ornis.dtos.users.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = NicknameUnicityValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NicknameUnicity {

    String message() default "{ornis.validation.constraints.NicknameUnicity.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
