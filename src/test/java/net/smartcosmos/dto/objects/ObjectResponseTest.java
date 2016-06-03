package net.smartcosmos.dto.objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ObjectResponseTest {

    @Test
    public void thatVersionIsSet() {
        ObjectResponse entity = ObjectResponse.builder().build();

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
            getVersion = ObjectResponse.class.getDeclaredMethod("setVersion", int.class);
        } catch (NoSuchMethodException e) {
            // that's what we expect
        }
        assertNull(getVersion);
    }

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        ObjectResponse response = ObjectResponse.builder()
            .type("entityReferenceType")
            .name("name")
            .lastModifiedTimestamp(123L)
            .urn("urn")
            .build();

        assertNotEquals(0, response.getVersion());

        String jsonString = mapper.writeValueAsString(response);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }
}
