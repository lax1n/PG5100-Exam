package no.nith.pg5100.dto.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by August on 12/3/2015.
 */

@Constraint(validatedBy = EventDescriptionValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEventDescription {
    String message() default "Description must be NULL or longer than 100 characters!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
