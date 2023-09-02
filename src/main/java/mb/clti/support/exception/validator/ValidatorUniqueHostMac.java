package mb.clti.support.exception.validator;

import mb.clti.support.exception.annotation.UniqueHostMac;
import mb.clti.support.persistence.payload.request.DTORequestHost;
import mb.clti.support.service.ServiceHost;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueHostMac implements ConstraintValidator<UniqueHostMac, DTORequestHost> {

    @Autowired
    private ServiceHost serviceHost;

    @Override
    public void initialize(UniqueHostMac constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestHost value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getMac()) && !serviceHost.existsByMac(value.getMac()) ||
                !Validator.isNull(value.getMac()) && !Validator.isNull(value.getId()) && !serviceHost.existsByMacAndIdNot(value.getMac(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}