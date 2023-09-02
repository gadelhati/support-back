package mb.clti.support.exception.validator;

import mb.clti.support.exception.annotation.UniqueNameHost;
import mb.clti.support.persistence.payload.request.DTORequestHost;
import mb.clti.support.service.ServiceHost;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameHost implements ConstraintValidator<UniqueNameHost, DTORequestHost> {

    @Autowired
    private ServiceHost serviceHost;

    @Override
    public void initialize(UniqueNameHost constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestHost value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceHost.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceHost.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}