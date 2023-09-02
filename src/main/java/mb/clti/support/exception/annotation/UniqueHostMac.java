package mb.clti.support.exception.annotation;

import mb.clti.support.exception.validator.ValidatorUniqueHostMac;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueHostMac.class })
@Documented
public @interface UniqueHostMac {

    String message() default "{unique.host.mac}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}