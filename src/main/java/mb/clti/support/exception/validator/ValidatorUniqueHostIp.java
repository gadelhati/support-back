package mb.clti.support.exception.validator;

import mb.clti.support.exception.annotation.UniqueHostIp;
import mb.clti.support.persistence.payload.request.DTORequestHost;
import mb.clti.support.service.ServiceHost;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueHostIp implements ConstraintValidator<UniqueHostIp, DTORequestHost> {

    @Autowired
    private ServiceHost serviceHost;

    @Override
    public void initialize(UniqueHostIp constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestHost value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getIp()) && !serviceHost.existsByIp(value.getIp()) ||
                !Validator.isNull(value.getIp()) && !Validator.isNull(value.getId()) && !serviceHost.existsByIpAndIdNot(value.getIp(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}