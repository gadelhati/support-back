package mb.clti.support.exception.validator;

import mb.clti.support.exception.annotation.UniqueNameUser;
import mb.clti.support.persistence.payload.request.DTORequestUserEntity;
import mb.clti.support.service.ServiceUserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static mb.clti.support.exception.validator.Validator.isNull;

public class ValidatorUniqueNameUser implements ConstraintValidator<UniqueNameUser, DTORequestUserEntity> {

    @Autowired
    private ServiceUserEntity serviceUserEntity;

    @Override
    public void initialize(UniqueNameUser constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestUserEntity value, ConstraintValidatorContext context) {
        if (!isNull(value.getUsername()) && !serviceUserEntity.existsByName(value.getUsername()) ||
            !isNull(value.getUsername()) && !isNull(value.getId()) && !serviceUserEntity.existsByNameAndIdNot(value.getUsername(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}