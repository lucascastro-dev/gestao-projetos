package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validate;

import com.gestaoprojetos.srvgestaoprojetos.domain.form.ActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateDateActivity;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ValidateDateActivityTest {

    @InjectMocks
    private ValidateDateActivity validateDateActivity;

    private IActivityForm activityForm = Instancio.of(ActivityForm.class).create();

    @Test
    void shouldSendExceptionWhenStartDateIsBeforeTheCurrentOne() {
        activityForm.setStartDate(LocalDate.of(2023, 10, 30));

        var error = Assertions.assertThrows(InvalidDataException.class, () -> validateDateActivity.runTask(activityForm));

        Assertions.assertEquals("Data informada não pode ser anterior a data atual", error.getMessage());
    }

    @Test
    void shouldSendExceptionWhenEndDateIsBeforeTheCurrentOne() {
        activityForm.setStartDate(LocalDate.now());
        activityForm.setEndDate(LocalDate.of(2023, 10, 30));

        var error = Assertions.assertThrows(InvalidDataException.class, () -> validateDateActivity.runTask(activityForm));

        Assertions.assertEquals("Data fim informada não pode ser anterior a data atual", error.getMessage());
    }

    @Test
    void shouldSendExceptionWhenEndDateIsBeforeTheStartDate() {
        activityForm.setStartDate(LocalDate.of(2024, 05, 30));
        activityForm.setEndDate(LocalDate.of(2024, 05, 25));

        var error = Assertions.assertThrows(InvalidDataException.class, () -> validateDateActivity.runTask(activityForm));

        Assertions.assertEquals("Data fim não pode ser anterior a data início", error.getMessage());
    }
}
