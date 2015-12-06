package no.nith.pg5100.dto.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by August on 12/3/2015.
 */
public class EventDescriptionValidator implements ConstraintValidator<ValidEventDescription, String> {

    @Override
    public void initialize(ValidEventDescription validEventDescription){}

    @Override
    public boolean isValid(String description, ConstraintValidatorContext constraintValidatorContext){
        if(description == null)
            return true;
        return (description.length() < 100);
    }
}
