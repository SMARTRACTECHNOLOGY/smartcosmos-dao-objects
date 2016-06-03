package net.smartcosmos.dto.objects;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Basic Unit Tests for the ObjectCreate object...
 */
@SuppressWarnings("Duplicates")
public class ObjectCreateTest {

    @Test
    public void thatObjectCreateAlwaysHasActiveFlag() throws Exception {
        ObjectCreate objectCreate = ObjectCreate.builder().objectUrn("objectUrn").type("type").name("name").build();

        assertTrue(objectCreate.getActiveFlag());
    }

    @Test
    public void thatVersionIsSet() {
        ObjectCreate entity = ObjectCreate.builder().build();

        assertNotNull(entity.getVersion());
        assertEquals(1, entity.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test
    public void thatVersionHasNoSetter() {
        Method getVersion = null;
        try {
            getVersion = ObjectCreate.class.getDeclaredMethod("setVersion", int.class);
        } catch (NoSuchMethodException e) {
            // that's what we expect
        }
        assertNull(getVersion);
    }
}
