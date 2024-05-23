package com.gestaoprojetos.srvgestaoprojetos.domain.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActivityDtoTest {

    @Test
    void testConstructor() {
        ActivityDto activityDto = new ActivityDto();

        activityDto.setIdActivity(1L);
        activityDto.setName("Test Activity");
        activityDto.setDescription("Test Description");
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        activityDto.setStartDate(startDate);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        activityDto.setEndDate(endDate);
        activityDto.setStatus(true);
        ProjectDto projectDto = new ProjectDto();
        activityDto.setProject(projectDto);

        assertEquals(1L, activityDto.getIdActivity());
        assertEquals("Test Activity", activityDto.getName());
        assertEquals("Test Description", activityDto.getDescription());
        assertEquals(startDate, activityDto.getStartDate());
        assertEquals(endDate, activityDto.getEndDate());
        assertTrue(activityDto.getStatus());
        assertSame(projectDto, activityDto.getProject());
    }
}