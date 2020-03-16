package com.smartoffice.climate.validation.control;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.smartoffice.climate.validation.control.CustomDateValidator.DATE_FORMAT;

/**
 * @author michael_loibl
 * @since 16.03.20
 *
 * Bean validation annotation that specifies the custom date format.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Constraint(validatedBy = CustomDateValidator.class)
@Documented
public @interface CustomDate {

  String message() default "date format must be: " + DATE_FORMAT;

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
