package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validate;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.validation.ValidateIdActivity;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.ObjectNotFoundException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.activity.ActivityService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidateIdActivityTest {

    @InjectMocks
    private ValidateIdActivity validateIdActivity;
    @Mock
    private ActivityService activityService;

    private IActivityForm activityForm;
    private IActivityEntity activityEntity;

    @BeforeEach
    void init() {
        activityForm = Instancio.of(ActivityForm.class).create();
    }

    @Test
    void whenValidateIdActivityShouldNotThrowException() {
        activityEntity = Instancio.of(ActivityEntity.class).create();
        when(activityService.findActivityById(anyLong())).thenReturn(activityEntity);

        assertDoesNotThrow(() -> validateIdActivity.runTask(activityForm));

        verify(activityService, times(1)).findActivityById(anyLong());
    }

    @Test
    void whenActivityIsActiveShouldThrowException() {
        var error = Assertions.assertThrows(ObjectNotFoundException.class, () -> validateIdActivity.runTask(activityForm));

        Assertions.assertEquals("Atividade não encontrada", error.getMessage());
    }
}
