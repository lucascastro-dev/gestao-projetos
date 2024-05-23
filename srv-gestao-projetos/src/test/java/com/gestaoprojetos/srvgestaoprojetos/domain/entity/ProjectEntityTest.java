package com.gestaoprojetos.srvgestaoprojetos.domain.entity;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectEntityTest {
    @Test
    void testNoArgsConstructor() {
        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setIdProject(1L);
        projectEntity.setName("Test Project");
        projectEntity.setDescription("Test Description");
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        projectEntity.setStartDate(startDate);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        projectEntity.setEndDate(endDate);
        projectEntity.setStatus(true);
        ClientEntity clientEntity = new ClientEntity();
        projectEntity.setClient(clientEntity);

        assertEquals(1L, projectEntity.getIdProject());
        assertEquals("Test Project", projectEntity.getName());
        assertEquals("Test Description", projectEntity.getDescription());
        assertEquals(startDate, projectEntity.getStartDate());
        assertEquals(endDate, projectEntity.getEndDate());
        assertTrue(projectEntity.getStatus());
        assertSame(clientEntity, projectEntity.getClient());
    }

    @Test
    void testAllArgsConstructor() {
        IProjectForm projectForm = mock(IProjectForm.class);

        when(projectForm.getIdProject()).thenReturn(1L);
        when(projectForm.getName()).thenReturn("Test Project");
        when(projectForm.getDescription()).thenReturn("Test Description");
        when(projectForm.getStartDate()).thenReturn(LocalDate.of(2023, 1, 1));
        when(projectForm.getEndDate()).thenReturn(LocalDate.of(2023, 12, 31));
        when(projectForm.getStatus()).thenReturn(true);
        when(projectForm.getIdClient()).thenReturn(2L);

        ProjectEntity projectEntity = new ProjectEntity(projectForm);

        assertEquals(1L, projectEntity.getIdProject());
        assertEquals("Test Project", projectEntity.getName());
        assertEquals("Test Description", projectEntity.getDescription());
        assertEquals(LocalDate.of(2023, 1, 1), projectEntity.getStartDate());
        assertEquals(LocalDate.of(2023, 12, 31), projectEntity.getEndDate());
        assertTrue(projectEntity.getStatus());
        assertNotNull(projectEntity.getClient());
        assertEquals(2L, projectEntity.getClient().getIdClient());
    }
}
