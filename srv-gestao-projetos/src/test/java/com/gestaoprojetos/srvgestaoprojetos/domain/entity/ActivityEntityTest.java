package com.gestaoprojetos.srvgestaoprojetos.domain.entity;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActivityEntityTest {
    @Test
    void testNoArgsConstructor() {
        ActivityEntity activityEntity = new ActivityEntity();

        activityEntity.setIdActivity(1L);
        activityEntity.setName("Test Activity");
        activityEntity.setDescription("Test Description");
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        activityEntity.setStartDate(startDate);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        activityEntity.setEndDate(endDate);
        activityEntity.setStatus(true);
        ProjectEntity projectEntity = new ProjectEntity();
        activityEntity.setProjects(projectEntity);

        assertEquals(1L, activityEntity.getIdActivity());
        assertEquals("Test Activity", activityEntity.getName());
        assertEquals("Test Description", activityEntity.getDescription());
        assertEquals(startDate, activityEntity.getStartDate());
        assertEquals(endDate, activityEntity.getEndDate());
        assertTrue(activityEntity.getStatus());
        assertSame(projectEntity, activityEntity.getProjects());
    }

    @Test
    void testAllArgsConstructor() {
        IActivityForm activityForm = mock(IActivityForm.class);

        when(activityForm.getIdActivity()).thenReturn(1L);
        when(activityForm.getName()).thenReturn("Test Activity");
        when(activityForm.getDescription()).thenReturn("Test Description");
        when(activityForm.getStartDate()).thenReturn(LocalDate.of(2023, 1, 1));
        when(activityForm.getEndDate()).thenReturn(LocalDate.of(2023, 12, 31));
        when(activityForm.getStatus()).thenReturn(true);
        when(activityForm.getIdProjects()).thenReturn(2L);

        ActivityEntity activityEntity = new ActivityEntity(activityForm);

        assertEquals(1L, activityEntity.getIdActivity());
        assertEquals("Test Activity", activityEntity.getName());
        assertEquals("Test Description", activityEntity.getDescription());
        assertEquals(LocalDate.of(2023, 1, 1), activityEntity.getStartDate());
        assertEquals(LocalDate.of(2023, 12, 31), activityEntity.getEndDate());
        assertTrue(activityEntity.getStatus());
        assertNotNull(activityEntity.getProjects());
        assertEquals(2L, activityEntity.getProjects().getIdProject());
    }
}
