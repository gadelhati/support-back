package mb.clti.support.exception.validator;

import mb.clti.support.exception.annotation.HasMore;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorHasMore implements ConstraintValidator<HasMore, String> {

    @Override
    public void initialize(HasMore constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Validator.hasMore(8, value)) {
            return true;
        } else {
            return false;
        }
    }
}