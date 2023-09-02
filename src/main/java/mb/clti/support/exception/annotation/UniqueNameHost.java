package mb.clti.support.exception.annotation;

import mb.clti.support.exception.validator.ValidatorUniqueNameHost;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameHost.class })
@Documented
public @interface UniqueNameHost {

    String message() default "{unique.name.host}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}