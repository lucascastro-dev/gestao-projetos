package com.gestaoprojetos.srvgestaoprojetos.domain.form;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectFormTest {
    @Test
    void testNoArgsConstructor() {
        ProjectForm projectForm = new ProjectForm();

        projectForm.setIdProject(1L);
        projectForm.setName("Test Project");
        projectForm.setDescription("Test Description");
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        projectForm.setStartDate(startDate);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        projectForm.setEndDate(endDate);
        projectForm.setStatus(true);
        projectForm.setIdClient(2L);

        assertEquals(1L, projectForm.getIdProject());
        assertEquals("Test Project", projectForm.getName());
        assertEquals("Test Description", projectForm.getDescription());
        assertEquals(startDate, projectForm.getStartDate());
        assertEquals(endDate, projectForm.getEndDate());
        assertTrue(projectForm.getStatus());
        assertEquals(2L, projectForm.getIdClient());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        ProjectForm projectForm = new ProjectForm(1L, "Test Project", "Test Description", startDate, endDate, true, 2L);

        assertEquals(1L, projectForm.getIdProject());
        assertEquals("Test Project", projectForm.getName());
        assertEquals("Test Description", projectForm.getDescription());
        assertEquals(startDate, projectForm.getStartDate());
        assertEquals(endDate, projectForm.getEndDate());
        assertTrue(projectForm.getStatus());
        assertEquals(2L, projectForm.getIdClient());
    }

    @Test
    void testBuilder() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        ProjectForm projectForm = ProjectForm.builder()
                .idProject(1L)
                .name("Test Project")
                .description("Test Description")
                .startDate(startDate)
                .endDate(endDate)
                .status(true)
                .idClient(2L)
                .build();

        assertEquals(1L, projectForm.getIdProject());
        assertEquals("Test Project", projectForm.getName());
        assertEquals("Test Description", projectForm.getDescription());
        assertEquals(startDate, projectForm.getStartDate());
        assertEquals(endDate, projectForm.getEndDate());
        assertTrue(projectForm.getStatus());
        assertEquals(2L, projectForm.getIdClient());
    }
}
