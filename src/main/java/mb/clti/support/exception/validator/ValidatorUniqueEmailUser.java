package mb.clti.support.exception.validator;

import mb.clti.support.exception.annotation.UniqueEmailUser;
import mb.clti.support.persistence.payload.request.DTORequestUserEntity;
import mb.clti.support.service.ServiceUserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueEmailUser implements ConstraintValidator<UniqueEmailUser, DTORequestUserEntity> {

    @Autowired
    private ServiceUserEntity serviceUser;

    @Override
    public void initialize(UniqueEmailUser constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestUserEntity value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getEmail()) && !serviceUser.existsByEmail(value.getEmail()) ||
                !Validator.isNull(value.getEmail()) && !Validator.isNull(value.getId()) && !serviceUser.existsByEmailAndIdNot(value.getEmail(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}