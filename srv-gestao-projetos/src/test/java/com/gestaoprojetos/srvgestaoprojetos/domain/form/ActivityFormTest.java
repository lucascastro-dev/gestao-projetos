package com.gestaoprojetos.srvgestaoprojetos.domain.form;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActivityFormTest {
    @Test
    void testNoArgsConstructor() {
        ActivityForm activityForm = new ActivityForm();

        activityForm.setIdActivity(1L);
        activityForm.setName("Test Activity");
        activityForm.setDescription("Test Description");
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        activityForm.setStartDate(startDate);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        activityForm.setEndDate(endDate);
        activityForm.setStatus(true);
        activityForm.setIdProjects(2L);

        assertEquals(1L, activityForm.getIdActivity());
        assertEquals("Test Activity", activityForm.getName());
        assertEquals("Test Description", activityForm.getDescription());
        assertEquals(startDate, activityForm.getStartDate());
        assertEquals(endDate, activityForm.getEndDate());
        assertTrue(activityForm.getStatus());
        assertEquals(2L, activityForm.getIdProjects());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        ActivityForm activityForm = new ActivityForm(1L, "Test Activity", "Test Description", startDate, endDate, true, 2L);

        assertEquals(1L, activityForm.getIdActivity());
        assertEquals("Test Activity", activityForm.getName());
        assertEquals("Test Description", activityForm.getDescription());
        assertEquals(startDate, activityForm.getStartDate());
        assertEquals(endDate, activityForm.getEndDate());
        assertTrue(activityForm.getStatus());
        assertEquals(2L, activityForm.getIdProjects());
    }

    @Test
    void testBuilder() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        ActivityForm activityForm = ActivityForm.builder()
                .idActivity(1L)
                .name("Test Activity")
                .description("Test Description")
                .startDate(startDate)
                .endDate(endDate)
                .status(true)
                .idProjects(2L)
                .build();

        assertEquals(1L, activityForm.getIdActivity());
        assertEquals("Test Activity", activityForm.getName());
        assertEquals("Test Description", activityForm.getDescription());
        assertEquals(startDate, activityForm.getStartDate());
        assertEquals(endDate, activityForm.getEndDate());
        assertTrue(activityForm.getStatus());
        assertEquals(2L, activityForm.getIdProjects());
    }
}
