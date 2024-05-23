package com.gestaoprojetos.srvgestaoprojetos.domain.manager.project.validation;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.project.IProjectForm;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ValidateDateProjectTest {
    @InjectMocks
    private ValidateDateProject validateDateProject;

    private IProjectForm activityForm = Instancio.of(ProjectForm.class).create();

    @Test
    void shouldSendExceptionWhenStartDateIsBeforeTheCurrentOne() {
        activityForm.setStartDate(LocalDate.of(2023, 10, 30));

        var error = Assertions.assertThrows(InvalidDataException.class, () -> validateDateProject.runTask(activityForm));

        Assertions.assertEquals("Data informada não pode ser anterior a data atual", error.getMessage());
    }

    @Test
    void shouldSendExceptionWhenEndDateIsBeforeTheCurrentOne() {
        activityForm.setStartDate(LocalDate.now());
        activityForm.setEndDate(LocalDate.of(2023, 10, 30));

        var error = Assertions.assertThrows(InvalidDataException.class, () -> validateDateProject.runTask(activityForm));

        Assertions.assertEquals("Data fim informada não pode ser anterior a data atual", error.getMessage());
    }

    @Test
    void shouldSendExceptionWhenEndDateIsBeforeTheStartDate() {
        activityForm.setStartDate(LocalDate.of(2024, 05, 30));
        activityForm.setEndDate(LocalDate.of(2024, 05, 25));

        var error = Assertions.assertThrows(InvalidDataException.class, () -> validateDateProject.runTask(activityForm));

        Assertions.assertEquals("Data fim não pode ser anterior a data início", error.getMessage());
    }
}
