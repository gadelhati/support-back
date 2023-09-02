package mb.clti.support.exception.validator;

import mb.clti.support.exception.annotation.HasLetter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorHasLetter implements ConstraintValidator<HasLetter, String> {

    @Override
    public void initialize(HasLetter constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Validator.hasLetter(value)) {
            return true;
        } else {
            return false;
        }
    }
}