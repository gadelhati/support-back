package mb.clti.support.exception.annotation;

import mb.clti.support.exception.validator.ValidatorHasLetter;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorHasLetter.class })
@Documented
public @interface HasLetter {

    String message() default "{has.letter}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}