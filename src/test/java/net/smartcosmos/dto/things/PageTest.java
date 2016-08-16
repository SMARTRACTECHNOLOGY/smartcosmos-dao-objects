package net.smartcosmos.dto.things;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class PageTest {

    @Test
    public void thatBuilderEmptyWorks() {

        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .build();
        assertNotNull(page);
    }

    @Test
    public void thatBuilderEmptyDataWorks() {

        List<ThingResponse> data = new ArrayList<>();

        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .data(data)
            .build();
        assertNotNull(page);
        assertEquals(data, page.getData());
    }

    @Test
    public void thatBuilderNullDataWorks() {

        List<ThingResponse> data = new ArrayList<>();
        data.add(ThingResponse.builder()
                     .build());

        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .data(data)
            .build();
        assertNotNull(page);
        assertNotNull(page.getData());
        assertFalse(page.getData()
                        .isEmpty());
        assertEquals(1,
                     page.getData()
                         .size());
    }

    @Test
    public void thatBuilderDataWorks() {

        List<ThingResponse> data = null;

        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .data(data)
            .build();
        assertNotNull(page);
        assertNotNull(page.getData());
        assertTrue(page.getData()
                       .isEmpty());
    }

    @Test
    public void thatBuilderDataWorksWithoutType() {

        List data = new ArrayList();

        Page page = Page.builder()
            .data(data)
            .build();

        assertNotNull(page);
        assertNotNull(page.getData());
        assertTrue(page.getData()
                       .isEmpty());
    }

    @Test
    public void thatBuilderPageWorks() {

        PageInformation pageInfo = PageInformation.builder()
            .build();

        Page<ThingResponse> page = Page.<ThingResponse>builder()
            .page(pageInfo)
            .build();
        assertNotNull(page);
        assertNotNull(page.getPage());
        assertEquals(pageInfo, page.getPage());
    }

    @Test
    public void thatBuilderPageHasDefaultValues() {

        Page<ThingResponse> page = Page.<ThingResponse>builder().build();

        assertNotNull(page.getData());
        Collection<ThingResponse> data = page.getData();
        assertTrue(data.isEmpty());

        assertNotNull(page.getPage());
        PageInformation pageInformation = page.getPage();
        assertEquals(0, pageInformation.getNumber());
        assertEquals(0, pageInformation.getSize());
        assertEquals(0, pageInformation.getTotalPages());
        assertEquals(0, pageInformation.getTotalElements());
    }
}
