package mb.clti.support.exception.annotation;

import mb.clti.support.exception.validator.ValidatorUniqueNameRole;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorUniqueNameRole.class)
public @interface UniqueNameRole {

    public String message() default "{unique.name.role}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}