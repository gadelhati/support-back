package mb.clti.support.exception.validator;

import mb.clti.support.exception.annotation.HasLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorHasLength implements ConstraintValidator<HasLength, String> {

    @Override
    public void initialize(HasLength constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Validator.hasLength(8, value)) {
            return true;
        } else {
            return false;
        }
    }
}