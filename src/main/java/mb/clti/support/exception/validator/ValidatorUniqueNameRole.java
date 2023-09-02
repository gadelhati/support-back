package mb.clti.support.exception.validator;

import mb.clti.support.exception.annotation.UniqueNameRole;
import mb.clti.support.persistence.payload.request.DTORequestRole;
import mb.clti.support.service.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameRole implements ConstraintValidator<UniqueNameRole, DTORequestRole> {

    @Autowired
    private ServiceRole serviceRole;

    @Override
    public void initialize(UniqueNameRole constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestRole value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceRole.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceRole.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}