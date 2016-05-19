package net.smartcosmos.dto.annotation;

import net.smartcosmos.dto.objects.validation.ObjectsUpdateIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A constraint annotation to check if an identifier is appropriately specified, like objectUrn or urn.
 */
@Documented
@Target({ANNOTATION_TYPE, TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = { ObjectsUpdateIdValidator.class} )
public @interface SmartCosmosIdDefined {
    String message() default "URN and Object URN may not be null, and only one of them may be defined";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
