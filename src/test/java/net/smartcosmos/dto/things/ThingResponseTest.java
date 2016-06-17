package net.smartcosmos.dto.things;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;


public class ThingResponseTest {

    @Test
    public void thatVersionIsSet() {
        ThingResponse entity = ThingResponse.builder().build();

        assertNotNull(entity.getVersion());
        assertEquals(1, entity.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test(expected = NoSuchMethodException.class)
    public void thatVersionHasNoSetter() throws Exception {
        ThingResponse.class.getDeclaredMethod("setVersion", int.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void thatUrnHasNoSetter() throws Exception {
        ThingResponse.class.getDeclaredMethod("setUrn", int.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void thatTypeHasNoSetter() throws Exception {
        ThingResponse.class.getDeclaredMethod("setType", int.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void thatActiveHasNoSetter() throws Exception {
        ThingResponse.class.getDeclaredMethod("setActive", int.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void thatTenantUrnHasNoSetter() throws Exception {
        ThingResponse.class.getDeclaredMethod("setTenantUrn", int.class);
    }

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        ThingResponse response = ThingResponse.builder()
            .type("entityReferenceType")
            .urn("urn")
            .build();

        assertNotEquals(0, response.getVersion());

        String jsonString = mapper.writeValueAsString(response);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }

    @Test
    public void thatBuilderEmptyWorks() {
        ThingResponse thing = ThingResponse.builder()
            .build();
        assertNotNull(thing);
    }

    @Test
    public void thatBuilderTypeWorks() {
        final String type = "type";

        ThingResponse thing = ThingResponse.builder()
            .type(type)
            .build();
        assertNotNull(thing);
        assertEquals(type, thing.getType());
    }

    @Test
    public void thatBuilderTypeUrnWorks() {
        final String type = "type";
        final String urn = "urn";

        ThingResponse thing = ThingResponse.builder()
            .type(type)
            .urn(urn)
            .build();
        assertNotNull(thing);
        assertEquals(type, thing.getType());
        assertEquals(urn, thing.getUrn());
    }

    @Test
    public void thatBuilderTenantUrnWorks() {
        final String tenantUrn = "tenantUrn";

        ThingResponse thing = ThingResponse.builder()
            .tenantUrn(tenantUrn)
            .build();
        assertNotNull(thing);
        assertEquals(tenantUrn, thing.getTenantUrn());
    }

    @Test
    public void thatBuilderActiveWorks() {
        final Boolean active = false;

        ThingResponse thing = ThingResponse.builder()
            .active(active)
            .build();
        assertNotNull(thing);
        assertFalse(thing.getActive());
    }

    @Test
    public void testAllArgsConstructor() {
        final String urn = "urn";
        final String type = "type";
        final Boolean active = true;
        final String tenantUrn = "tenantUrn";

        ThingResponse thing = new ThingResponse(urn, type, tenantUrn, active);
        assertNotNull(thing);

        assertEquals(urn, thing.getUrn());
        assertEquals(type, thing.getType());
        assertEquals(tenantUrn, thing.getTenantUrn());
        assertEquals(active, thing.getActive());
    }
}
