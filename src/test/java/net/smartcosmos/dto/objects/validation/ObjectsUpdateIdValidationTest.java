package net.smartcosmos.dto.objects.validation;

import net.smartcosmos.dto.objects.ObjectUpdate;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObjectsUpdateIdValidationTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validUrn() {

        ObjectUpdate update = ObjectUpdate.builder()
            .urn("urn:uuid:MY-TEST-URN")
            .build();

        Set<ConstraintViolation<ObjectUpdate>> constraintViolations =
            validator.validate(update);

        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void validObjectUrn() {

        ObjectUpdate update = ObjectUpdate.builder()
            .objectUrn("urn:MY-TEST-OBJECT-URN")
            .build();

        Set<ConstraintViolation<ObjectUpdate>> constraintViolations =
            validator.validate(update);

        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void invalid() {
        ObjectUpdate update = ObjectUpdate.builder()
            .build();

        Set<ConstraintViolation<ObjectUpdate>> constraintViolations =
            validator.validate(update);

        assertFalse(constraintViolations.isEmpty());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("URN and Object URN may not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void overspecified() {
        ObjectUpdate update = ObjectUpdate.builder()
            .urn("urn:uuid:MY-TEST-URN")
            .objectUrn("urn:MY-TEST-OBJECT-URN")
            .build();

        Set<ConstraintViolation<ObjectUpdate>> constraintViolations =
            validator.validate(update);

        assertFalse(constraintViolations.isEmpty());
        assertEquals( 1, constraintViolations.size() );
        assertEquals("either URN or Object URN may be defined", constraintViolations.iterator().next().getMessage());
    }
}
