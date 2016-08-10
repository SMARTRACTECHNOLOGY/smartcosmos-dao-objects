package net.smartcosmos.dto.things;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Basic Unit Tests for the ThingCreate object...
 */
@SuppressWarnings("Duplicates")
public class ThingCreateTest {

    @Test
    public void thatThingCreateAlwaysHasActive() throws Exception {

        ThingCreate thingCreate = ThingCreate.builder()
            .urn("urn")
            .type("type")
            .build();

        assertTrue(thingCreate.getActive());
    }

    @Test
    public void thatVersionIsSet() {

        ThingCreate entity = ThingCreate.builder()
            .build();

        assertNotNull(entity.getVersion());
        assertEquals(1, entity.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test(expected = NoSuchMethodException.class)
    public void thatVersionHasNoSetter() throws Exception {

        ThingCreate.class.getDeclaredMethod("setVersion", int.class);
    }

    @Test
    public void thatBuilderEmptyWorks() {

        ThingCreate thing = ThingCreate.builder()
            .build();
        assertNotNull(thing);
    }

    @Test
    public void thatBuilderTypeWorks() {

        final String type = "type";

        ThingCreate thing = ThingCreate.builder()
            .type(type)
            .build();
        assertNotNull(thing);
        assertEquals(type, thing.getType());
    }

    @Test
    public void thatBuilderTypeUrnWorks() {

        final String type = "type";
        final String urn = "urn";

        ThingCreate thing = ThingCreate.builder()
            .type(type)
            .urn(urn)
            .build();
        assertNotNull(thing);
        assertEquals(type, thing.getType());
        assertEquals(urn, thing.getUrn());
    }

    @Test
    public void thatBuilderActiveWorks() {

        final Boolean active = false;

        ThingCreate thing = ThingCreate.builder()
            .active(active)
            .build();
        assertNotNull(thing);
        assertFalse(thing.getActive());
    }

    @Test
    public void thatGetterSetterUrnWorks() {

        final String urn = "urn";

        ThingCreate thing = ThingCreate.builder()
            .build();
        assertNotNull(thing);

        thing.setUrn(urn);
        assertEquals(urn, thing.getUrn());
    }

    @Test
    public void thatGetterSetterTypeWorks() {

        final String type = "type";

        ThingCreate thing = ThingCreate.builder()
            .build();
        assertNotNull(thing);

        thing.setType(type);
        assertEquals(type, thing.getType());
    }

    @Test
    public void thatGetterSetterActiveWorks() {

        final Boolean active = true;

        ThingCreate thing = ThingCreate.builder()
            .build();
        assertNotNull(thing);

        thing.setActive(active);
        assertEquals(active, thing.getActive());
    }

    @Test
    public void testAllArgsConstructor() {

        final String urn = "urn";
        final String type = "type";
        final Boolean active = true;

        ThingCreate thing = new ThingCreate(urn, type, active);
        assertNotNull(thing);

        assertEquals(urn, thing.getUrn());
        assertEquals(type, thing.getType());
        assertEquals(active, thing.getActive());
    }
}
