package br.com.victor.aifude.infra;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidDTOValidator.class })
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface ValidDTO {
    String message() default "{br.com.victor.aifude.infra.ValidDTO.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
