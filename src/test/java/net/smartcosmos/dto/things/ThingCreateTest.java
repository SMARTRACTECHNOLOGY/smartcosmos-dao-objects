package net.smartcosmos.dto.things;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Basic Unit Tests for the ThingCreate object...
 */
@SuppressWarnings("Duplicates")
public class ThingCreateTest {

    @Test
    public void thatThingCreateAlwaysHasActiveFlag() throws Exception {
        ThingCreate thingCreate = ThingCreate.builder().urn("urn").type("type").build();

        assertTrue(thingCreate.getActiveFlag());
    }

    @Test
    public void thatVersionIsSet() {
        ThingCreate entity = ThingCreate.builder().build();

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
            getVersion = ThingCreate.class.getDeclaredMethod("setVersion", int.class);
        } catch (NoSuchMethodException e) {
            // that's what we expect
        }
        assertNull(getVersion);
    }
}
