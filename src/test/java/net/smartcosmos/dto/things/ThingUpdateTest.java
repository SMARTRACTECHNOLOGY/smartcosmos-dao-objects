package net.smartcosmos.dto.things;

import org.junit.*;

import static org.junit.Assert.*;

public class ThingUpdateTest {

    @Test
    public void thatVersionIsSet() {

        ThingUpdate entity = ThingUpdate.builder()
            .build();

        assertNotNull(entity.getVersion());
        assertEquals(1, entity.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test(expected = NoSuchMethodException.class)
    public void thatVersionHasNoSetter() throws Exception {

        ThingUpdate.class.getDeclaredMethod("setVersion", int.class);
    }

    @Test
    public void thatBuilderEmptyWorks() {

        ThingUpdate thing = ThingUpdate.builder()
            .build();
        assertNotNull(thing);
    }

    @Test
    public void thatBuilderActiveWorks() {

        final Boolean active = false;

        ThingUpdate thing = ThingUpdate.builder()
            .active(active)
            .build();
        assertNotNull(thing);
        assertFalse(thing.getActive());
    }

    @Test
    public void thatGetterSetterActiveWorks() {

        final Boolean active = true;

        ThingUpdate thing = ThingUpdate.builder()
            .build();
        assertNotNull(thing);

        thing.setActive(active);
        assertEquals(active, thing.getActive());
    }

    @Test
    public void testNoArgsConstructor() {

        ThingUpdate thing = new ThingUpdate();
        assertNotNull(thing);
    }

    @Test
    public void testAllArgsConstructor() {

        final Boolean active = true;

        ThingUpdate thing = new ThingUpdate(active);
        assertNotNull(thing);

        assertEquals(active, thing.getActive());
    }
}
