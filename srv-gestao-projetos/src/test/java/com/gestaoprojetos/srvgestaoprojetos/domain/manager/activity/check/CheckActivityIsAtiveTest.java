package com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.check;

import com.gestaoprojetos.srvgestaoprojetos.domain.entity.ActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.form.ActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityEntity;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.activity.IActivityForm;
import com.gestaoprojetos.srvgestaoprojetos.domain.manager.activity.check.CheckActivityIsAtive;
import com.gestaoprojetos.srvgestaoprojetos.infra.exception.InvalidDataException;
import com.gestaoprojetos.srvgestaoprojetos.infra.service.activity.ActivityService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CheckActivityIsAtiveTest {

    @InjectMocks
    private CheckActivityIsAtive checkActivityIsAtive;
    @Mock
    private ActivityService activityService;

    private IActivityForm activityForm;
    private IActivityEntity activityEntity;

    @BeforeEach
    void init() {
        activityForm = Instancio.of(ActivityForm.class).create();

    }

    @Test
    void whenActivityIsActiveShouldNotThrowException() {
        activityEntity = Instancio.of(ActivityEntity.class).set(field(ActivityEntity::getStatus), false).create();
        when(activityService.findActivityById(anyLong())).thenReturn(activityEntity);

        assertDoesNotThrow(() -> checkActivityIsAtive.runTask(activityForm));

        verify(activityService, times(1)).findActivityById(anyLong());
    }

    @Test
    void whenActivityIsActiveShouldThrowException() {
        activityEntity = Instancio.of(ActivityEntity.class).set(field(ActivityEntity::getStatus), true).create();
        when(activityService.findActivityById(anyLong())).thenReturn(activityEntity);

        var error = Assertions.assertThrows(InvalidDataException.class, () -> checkActivityIsAtive.runTask(activityForm));

        Assertions.assertEquals("Não é possível deletar atividade quando ativa", error.getMessage());
    }
}
