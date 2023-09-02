package mb.clti.support.exception.annotation;

import mb.clti.support.exception.validator.ValidatorUniqueHostIp;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueHostIp.class })
@Documented
public @interface UniqueHostIp {

    String message() default "{unique.host.ip}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}