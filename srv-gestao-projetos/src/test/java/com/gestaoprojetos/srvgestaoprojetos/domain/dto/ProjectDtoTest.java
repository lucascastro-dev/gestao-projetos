package com.gestaoprojetos.srvgestaoprojetos.domain.dto;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.client.IClientEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectDtoTest {
    @Test
    void testConstructor() {
        ProjectDto projectDto = new ProjectDto();

        projectDto.setIdProject(1L);
        projectDto.setName("Test Project");
        projectDto.setDescription("Test Description");
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        projectDto.setStartDate(startDate);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        projectDto.setEndDate(endDate);
        projectDto.setStatus(true);
        ClientDto clientDto = new ClientDto();
        projectDto.setClient(clientDto);

        assertEquals(1L, projectDto.getIdProject());
        assertEquals("Test Project", projectDto.getName());
        assertEquals("Test Description", projectDto.getDescription());
        assertEquals(startDate, projectDto.getStartDate());
        assertEquals(endDate, projectDto.getEndDate());
        assertTrue(projectDto.getStatus());
        assertSame(clientDto, projectDto.getClient());
    }
}
