package net.smartcosmos.dto.things;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PageTest {

    /*
        The Lombok plugin in IntelliJ has some issues with generics, but Lombok itself is fine with that.
        It just needs some assistance on the right type.
        However, there probably will be some "compiler warnings" in the IDE, but not in the compiler itself.
        That's what tests are for, right? :)

        (see https://reinhard.codes/2015/07/14/project-lomboks-builder-annotation-and-generics/)
     */

    @Test
    public void thatBuilderEmptyWorks() {
        // Don't mind the IDE complaining about incompatible types - this code compiles.
        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .build();
        assertNotNull(page);
    }

    @Test
    public void thatBuilderEmptyDataWorks() {
        List<ThingResponse> data = new ArrayList<>();

        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .data(data) // No worries, this works!
            .build();
        assertNotNull(page);
        assertEquals(data, page.getData());
    }

    @Test
    public void thatBuilderNullDataWorks() {
        List<ThingResponse> data = new ArrayList<>();
        data.add(ThingResponse.builder().build());

        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .data(data) // No worries, this works!
            .build();
        assertNotNull(page);
        assertNotNull(page.getData());
        assertFalse(page.getData().isEmpty());
        assertEquals(1, page.getData().size());
    }

    @Test
    public void thatBuilderDataWorks() {
        List<ThingResponse> data = null;

        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .data(data) // No worries, this works!
            .build();
        assertNotNull(page);
        assertNotNull(page.getData());
        assertTrue(page.getData().isEmpty());
    }

    @Test
    public void thatBuilderPageWorks() {
        PageInformation pageInfo = PageInformation.builder().build();

        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .page(pageInfo)
            .build();
        assertNotNull(page);
        assertNotNull(page.getPage());
        assertEquals(pageInfo, page.getPage());
    }
}
