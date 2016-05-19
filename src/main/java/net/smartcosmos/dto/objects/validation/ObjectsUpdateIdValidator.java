package net.smartcosmos.dto.objects.validation;

import net.smartcosmos.dto.annotation.SmartCosmosIdDefined;
import net.smartcosmos.dto.objects.ObjectUpdate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Checks that either {@code objectUrn} or {@code urn} are defined (not {@code null}) for an {@link ObjectUpdate}.
 */
public class ObjectsUpdateIdValidator implements ConstraintValidator<SmartCosmosIdDefined, ObjectUpdate> {
    @Override
    public void initialize(SmartCosmosIdDefined smartCosmosIdDefined) {

    }

    @Override
    public boolean isValid(ObjectUpdate objectUpdate, ConstraintValidatorContext constraintValidatorContext) {

        // We want to override the default constraint violation message, and if we didn't disable the default violation,
        // we would end up with multiple violations.
        constraintValidatorContext.disableDefaultConstraintViolation();

        if (objectUpdate.getUrn() == null && objectUpdate.getObjectUrn() == null) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("URN and Object URN may not be null").addConstraintViolation();
            return false;
        }

        if (objectUpdate.getUrn() != null && objectUpdate.getObjectUrn() != null) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("either URN or Object URN may be defined").addConstraintViolation();
            return false;
        }

        return true;
    }
}
