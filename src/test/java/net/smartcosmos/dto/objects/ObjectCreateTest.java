package net.smartcosmos.dto.objects;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Basic Unit Tests for the ObjectCreate object...
 */
@SuppressWarnings("Duplicates")
public class ObjectCreateTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void thatObjectCreateAlwaysHasActiveFlag() throws Exception {
        ObjectCreate objectCreate = ObjectCreate.builder().objectUrn("objectUrn").type("type").name("name").build();

        assertTrue(objectCreate.getActiveFlag());
    }

    @Test
    public void thatObjectCreateMustHaveObjectURN() {

        ObjectCreate objectCreate = ObjectCreate.builder()
            .type("type")
            .name("name").build();

        Set<ConstraintViolation<ObjectCreate>> constraintViolations = validator.validate(objectCreate);

        assertFalse(constraintViolations.isEmpty());

        assertEquals(1, constraintViolations.size() );
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void thatObjectCreateMustNotHaveEmptyObjectURN() {

        ObjectCreate objectCreate = ObjectCreate.builder()
            .objectUrn("")
            .type("type")
            .name("name").build();

        Set<ConstraintViolation<ObjectCreate>> constraintViolations = validator.validate(objectCreate);

        assertFalse(constraintViolations.isEmpty());

        assertEquals(1, constraintViolations.size() );
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

}
