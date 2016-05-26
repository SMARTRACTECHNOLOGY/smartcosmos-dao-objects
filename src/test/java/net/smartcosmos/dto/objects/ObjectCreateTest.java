package net.smartcosmos.dto.objects;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
}
