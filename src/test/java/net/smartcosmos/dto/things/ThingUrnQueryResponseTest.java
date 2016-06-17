package net.smartcosmos.dto.things;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class ThingUrnQueryResponseTest {
    @Test
    public void thatVersionIsSet() {
        ThingUrnQueryResponse entity = ThingUrnQueryResponse.builder().build();

        assertNotNull(entity.getVersion());
        assertEquals(1, entity.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test(expected = NoSuchMethodException.class)
    public void thatVersionHasNoSetter() throws Exception {
        ThingUrnQueryResponse.class.getDeclaredMethod("setVersion", int.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void thatDataHasNoSetter() throws Exception {
        ThingUrnQueryResponse.class.getDeclaredMethod("setData", int.class);
    }

    @Test(expected = NoSuchMethodException.class)
    public void thatNotFoundHasNoSetter() throws Exception {
        ThingUrnQueryResponse.class.getDeclaredMethod("setNotFound", int.class);
    }

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        ThingUrnQueryResponse response = ThingUrnQueryResponse.builder()
            .data(new ArrayList<>())
            .notFound(new ArrayList<>())
            .build();

        assertNotEquals(0, response.getVersion());

        String jsonString = mapper.writeValueAsString(response);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }

    @Test
    public void thatBuilderEmptyWorks() {
        ThingUrnQueryResponse response = ThingUrnQueryResponse.builder()
            .build();
        assertNotNull(response);
    }

    @Test
    public void thatBuilderDataWorks() {
        List<ThingResponse> data = new ArrayList<ThingResponse>();
        data.add(ThingResponse.builder().build());

        ThingUrnQueryResponse response = ThingUrnQueryResponse.builder()
            .data(data)
            .build();
        assertNotNull(response);

        assertEquals(data, response.getData());
    }

    @Test
    public void thatBuilderNotFoundWorks() {
        List<String> notFound = new ArrayList<String>();
        notFound.add("urn");

        ThingUrnQueryResponse response = ThingUrnQueryResponse.builder()
            .notFound(notFound)
            .build();
        assertNotNull(response);

        assertEquals(notFound, response.getNotFound());
    }

    @Test
    public void testAllArgsConstructor() {

        List<ThingResponse> data = new ArrayList<ThingResponse>();
        data.add(ThingResponse.builder().build());

        List<String> notFound = new ArrayList<String>();
        notFound.add("urn");

        ThingUrnQueryResponse response = new ThingUrnQueryResponse(data, notFound);
        assertNotNull(response);

        assertEquals(data, response.getData());
        assertEquals(notFound, response.getNotFound());
    }
}
